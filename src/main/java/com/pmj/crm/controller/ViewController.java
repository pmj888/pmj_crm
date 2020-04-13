package com.pmj.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 公开接口
     */
    @GetMapping(value = "/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }


}
