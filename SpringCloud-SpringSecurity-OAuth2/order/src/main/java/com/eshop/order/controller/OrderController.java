package com.eshop.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/r")
public class OrderController {

    @GetMapping(value = "/p1")
    @PreAuthorize("hasAnyAuthority('p1')") // 拥有p1权限方可发个文
    public String r1()
    {
        return "访问资源1";
    }

    @GetMapping(value = "/p2")
    @PreAuthorize("hasAnyAuthority('p3')") // 拥有p2权限方可发个文
    public String r2()
    {
        return "访问资源2";
    }
}
