package com.pmj.crm.controller;

import com.pmj.crm.service.IPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionControllerTest {


    @Autowired
    private IPermissionService iPermissionService;

    @Test
    public void getPermName(){

       System.out.println(iPermissionService.list());
    }

}