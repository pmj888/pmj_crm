package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Customer;
import com.pmj.crm.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private ICustomerService iCustomerService;

    @Test
    public void getList(){
        //设置mybatisPlus分页
        Page<Customer> p = new Page<Customer>();
        p.setSize(2);       //设置每页记录数
        p.setCurrent(1);     //设置当前页码
        iCustomerService.queryCustomerByEmpId(p,7);
        System.out.println(p.getRecords());
    }

}