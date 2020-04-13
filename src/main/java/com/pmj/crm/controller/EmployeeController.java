package com.pmj.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.EmpRole;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.service.IEmpRoleService;
import com.pmj.crm.service.IEmployeeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;


    /**
     *  查询一页员工信息
     *   url :  /emp/每页条数/当前页码
     *          /emp/10/1
     */
    @GetMapping("/employee")
    public Map getList(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object> ();

        //设置mybatisPlus分页
        Page<Employee> p = new Page<Employee>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Employee> iPage = iEmployeeService.selectList(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }


    /**
     *  删除用户
     */
    @DeleteMapping("/employee/del/{empId}")
    public Map del(@PathVariable Integer empId){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setIsDel(1);

        Map<String,Object> result = new HashMap<String,Object>();

        result.put("state",iEmployeeService.updateById(employee));

        return result;
    }



    /**
     *  新增用户
     */
    @PostMapping("/employee")
    public Map add(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",iEmployeeService.add(employee,roleId));
        return result;
    }


    /**
     *  修改用户
     */
    @PutMapping("/employee")
    public Map edit(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",iEmployeeService.update(employee,roleId));
        return result;
    }

}
