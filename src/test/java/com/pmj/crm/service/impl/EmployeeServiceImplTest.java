package com.pmj.crm.service.impl;

import com.pmj.crm.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Test
    public void selectByName(){
      System.out.println(iEmployeeService.selectByName("admin"));
    }

}