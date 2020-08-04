package com.eshop.microorder.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "micro-user")
public interface UserApiService {

    @GetMapping(value = "/user/u/r1")
    String r1();

    @GetMapping(value = "/user/u/r1")
    String r2();
}