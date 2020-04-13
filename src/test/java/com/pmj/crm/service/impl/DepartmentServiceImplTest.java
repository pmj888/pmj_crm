package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Department;
import com.pmj.crm.entity.Role;
import com.pmj.crm.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {

    @Autowired
    private IDepartmentService iDepartmentService;

    @Test
    public void getList(){
        //设置mybatisPlus分页
        Page<Department> p = new Page<Department>();
        p.setSize(2);       //设置每页记录数
        p.setCurrent(1);     //设置当前页码
        iDepartmentService.selectList(p);
        System.out.println(p.getRecords());
    }

}