package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Role;
import com.pmj.crm.mapper.RoleMapper;
import com.pmj.crm.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    private IRoleService iRoleService;

    @Test
    public void selectRolePage(){

        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(2);       //设置每页记录数
        p.setCurrent(1);     //设置当前页码
        IPage<Role> roleIPage = iRoleService.selectRolePage(p);
        System.out.println(roleIPage.getRecords());

    }

}