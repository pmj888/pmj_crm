package com.pmj.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.entity.Role;
import com.pmj.crm.entity.RolePermission;
import com.pmj.crm.service.IRolePermissionService;
import com.pmj.crm.service.IRoleService;
import com.pmj.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
public class RoleController {


    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IRolePermissionService iRolePermissionService;

    /**
     * 添加员工时查询角色
     */
    @GetMapping("/roleList")
    public List<Role> roles(){
        return iRoleService.list();
    }


    /**
     * 查询所有的角色
     */
    @GetMapping("/role")
    public Map getRolePage(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();

        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Role> roleIPage = iRoleService.selectRolePage(p);

        map.put("msg","查询情况");
        map.put("count",roleIPage.getTotal());
        map.put("data",roleIPage.getRecords());
        map.put("code",0);
        return map;
    }


    /**
     *  删除角色
     */
    @DeleteMapping("/role/del/{roleId}")
    public Map del(@PathVariable Integer roleId){
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDel(1);


        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",iRoleService.updateById(role));

        return result;
    }


    /**
     * 添加角色并添加前端勾选的角色权限
     * @param roleName 角色名称
     * @param permId   权限的id
     */
    @PostMapping("/role")
    public Map insertRole(String roleName,String permId){
        Map<String,Object> result = new HashMap<String,Object>();
        Role role = new Role(null,roleName,StringUtils.getNowTime(),StringUtils.getNowTime(),0,null,null);
        int i = iRoleService.insertRole(role);
        result.put("state",i);

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getRoleId());
        rolePermission.setCreateTime(role.getCreateTime());
        rolePermission.setUpdateTime(role.getCreateTime());
        rolePermission.setIsDel(0);
        if (i!=0){
            for(String id:permId.split(",")) {
                rolePermission.setPermId(Integer.parseInt(id));
                iRolePermissionService.save(rolePermission);
            }
        }
        return result;
    }


}
