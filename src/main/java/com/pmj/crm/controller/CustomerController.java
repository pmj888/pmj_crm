package com.pmj.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Customer;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.service.ICustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
 * @since 2020-04-05
 */
@RestController
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;


    /**
     *  查询一页客户信息
     *   url :  /emp/每页条数/当前页码
     *          /emp/10/1
     */
    @GetMapping("/customers")
    public Map getList(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object> ();
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee)subject.getPrincipal();

        //设置mybatisPlus分页
        Page<Customer> p = new Page<Customer>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码
        IPage<Customer> customerIPage = iCustomerService.queryCustomerByEmpId(p, employee.getEmpId());
        System.out.println("customerIPage"+customerIPage);
        map.put("msg","查询情况");
        map.put("count",customerIPage.getTotal());
        map.put("data",customerIPage.getRecords());
        map.put("code",0);
        return map;
    }


    /**
     *  新增客户
     */
    @PostMapping("/customers")
    public Map add(Customer customer){
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
        customer.setEmpId(employee.getEmpId());

         Map<String,Object> result = new HashMap<String,Object>();
         result.put("state",iCustomerService.save(customer));
        return result;
    }


    /**
     *  删除客户
     */
    @DeleteMapping("/customers/del/{customerId}")
    public Map del(@PathVariable Integer customerId){
        System.out.println("customerId---"+customerId);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",iCustomerService.removeById(customerId));
        return result;
    }





}
