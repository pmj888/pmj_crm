package com.pmj.crm.controller;


import com.pmj.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @since 2020-03-24
 */
@RestController
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;

    @PostMapping("/getPermName")
    public Map getPermName(){
       Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",iPermissionService.list());
        return map;
    }

}
