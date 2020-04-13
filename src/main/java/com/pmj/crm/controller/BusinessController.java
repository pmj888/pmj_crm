package com.pmj.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Business;
import com.pmj.crm.entity.Customer;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.service.IBusinessService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-12
 */
@RestController
public class BusinessController {

    @Autowired
    private IBusinessService iBusinessService;


    /**
     *  查询一页业务信息
     *   url :  /emp/每页条数/当前页码
     *          /emp/10/1
     */
    @GetMapping("/business")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();


        //设置mybatisPlus分页
        Page<Business> businessPage = new Page<Business>();
        businessPage.setSize(limit);       //设置每页记录数
        businessPage.setCurrent(page);     //设置当前页码
       IPage<Business> businessIPage = iBusinessService.queryBusiness(businessPage);

        System.out.println("customerIPage"+businessIPage);
        map.put("msg","查询情况");
        map.put("count",businessIPage.getTotal());
        map.put("data",businessIPage.getRecords());
        map.put("code",0);
        return map;
    }



}
