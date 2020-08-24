package com.eshop.microorder.controller;

import com.eshop.microorder.common.UserUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/r")
public class OrderController {

    @GetMapping(value = "/r1")
    public String r1(){
        return "访问资源1";
    }

    @GetMapping(value = "/r2")
    public String r2(){
        return "访问资源2";
    }

    @GetMapping(value = "/r3")
    public String r3(){
        return "访问资源3";
    }

    @GetMapping(value = "/r4") // 拥有p2权限方可发个文
    public static String r4(){
        return  UserUtil.getCurrentOperatorInfo();
    }
}
