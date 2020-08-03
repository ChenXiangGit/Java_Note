package com.eshop.microauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
//@EnableFeignClients(basePackages = {"cn.fllday.security.distruibuted.uaa"})
public class MicroAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroAuthApplication.class, args);
    }

}
