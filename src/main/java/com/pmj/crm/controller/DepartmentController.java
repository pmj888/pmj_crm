package com.pmj.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.*;
import com.pmj.crm.service.IDepartmentService;
import com.pmj.crm.service.IDeptRoleService;
import com.pmj.crm.utils.StringUtils;
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
public class DepartmentController {

   @Autowired
    private IDepartmentService iDepartmentService;

   @Autowired
    private IDeptRoleService iDeptRoleService;


    /**
     *  查询一页部门信息
     *   url :  /emp/每页条数/当前页码
     *          /emp/10/1
     */
    @GetMapping("/department")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();

        //设置mybatisPlus分页
        Page<Department> p = new Page<Department>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Department> iPage = iDepartmentService.selectList(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }


    /**
     *  删除部门
     */
    @DeleteMapping("/department/del/{deptId}")
    public Map del(@PathVariable Integer deptId){
        System.out.println(deptId);
        Department department = new Department();
        department.setDeptId(deptId);
        department.setIsDel(0);

        Map<String,Object> result = new HashMap<String,Object>();

        result.put("state",iDepartmentService.updateById(department));

        return result;
    }




    @PostMapping("/department")
    public Map insertRole(String deptName,String roleId){
        System.out.println("roleId"+roleId);
        Map<String,Object> result = new HashMap<String,Object>();
        Department department = new Department(null,deptName, StringUtils.getNowTime(),StringUtils.getNowTime(),0);
        int i = iDepartmentService.insertDepartment(department);
        result.put("state",i);

        DeptRole deptRole = new DeptRole();
        deptRole.setDeptId(department.getDeptId());

        deptRole.setCreateTime(department.getCreateTime());
        deptRole.setUpdateTime(department.getUpdateTime());
        deptRole.setIsDel(0);


        if (i!=0){
            for(String id:roleId.split(",")) {
                deptRole.setRoleId(Integer.parseInt(id));
                iDeptRoleService.save(deptRole);

            }
        }
        return result;
    }


}
