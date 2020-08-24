package com.eshop.microauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: Chen
 * @Date: 2020/8/19 16:46
 * @Version: 1.0
 */
public class TestController {

    @GetMapping(value = "/test1")
    public String test1() {
        return "test-1";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        return "test-2";
    }

    @GetMapping(value = "/test3")
    public String test3() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof OAuth2Authentication)){
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        String  principal = userAuthentication.getName();
        return principal;
    }
}