package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.EmpRole;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.mapper.EmpRoleMapper;
import com.pmj.crm.mapper.EmployeeMapper;
import com.pmj.crm.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pmj.crm.utils.SecurityUtils;
import com.pmj.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Transactional
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public IPage<Employee> selectList(Page<Employee> page) {
        return employeeMapper.selectList(page);
    }

    @Override
    public Employee selectByName(String empName) {
        return employeeMapper.selectByName(empName);
    }

    @Override
    public Integer add(Employee employee, Integer roleId) {
           /*
            1.获取盐
            2.shiro加盐加密
            3.用户信息存入对象，插入数据库，获取到插入的id
            4.将empId和roleId插入到emp_role表中
         */
        //从ShiroUtils类中随机生成盐
        employee.setSalt(SecurityUtils.randomSalt());
        //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
        employee.setPwd(SecurityUtils.encryptPassword(employee.getPwd(),employee.getSalt()));
        //设置时间，idDel
        employee.setCreateTime(StringUtils.getNowTime());
        employee.setUpdateTime(employee.getCreateTime());  //获取创建时间，可以提高一点性能
        employee.setIsDel(0);

        int result =  employeeMapper.insert(employee);

        int empId = employee.getEmpId();  //获取插入自增的id
        //将empId和roleId一同插入到  员工与角色关系表
        EmpRole empRole = new EmpRole(empId,roleId,StringUtils.getNowTime(),StringUtils.getNowTime(),0);

        empRoleMapper.insert(empRole);

        return result;
    }


    @Override
    public Integer update(Employee employee,Integer roleId) {
        //System.out.println("修改的员工信息："+employee);
        //判断用户是否输入密码，如果没有，获取的就是空字符串 ("")  就不修改密码
        if (!"".equals(employee.getPwd()) ){
            //从ShiroUtils类中随机生成盐
            employee.setSalt(SecurityUtils.randomSalt());
            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
            employee.setPwd(SecurityUtils.encryptPassword(employee.getPwd(), employee.getSalt()));
        }else {
            employee.setPwd(null);
        }
        //设置时间
        employee.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result =  employeeMapper.updateById(employee);


        EmpRole empRole = new EmpRole(employee.getEmpId(),roleId,null,StringUtils.getNowTime(),0);
        /*empRole.setUpdateTime(StringUtils.getNowTime());*/
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("emp_id",employee.getEmpId());
        empRoleMapper.update(empRole,wrapper);

        return result;
    }
}
