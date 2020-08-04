package com.eshop.microuser.controller;

import com.eshop.microuser.model.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/u")
public class UserController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限方可访问此url
    public String r1(){
        //获取用户身份信息
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDTO.getUsername()+"u访问资源1";
    }


    @GetMapping(value = "/r2")
    @PreAuthorize("hasAnyAuthority('p2')") // 拥有p2权限方可发个文
    public String r2()
    {
        return "u访问资源2";
    }
}
