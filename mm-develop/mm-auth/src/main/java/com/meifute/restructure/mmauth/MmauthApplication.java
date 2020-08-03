package com.meifute.restructure.mmauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.meifute.restructure.mmauth.mapper")
@EnableFeignClients(basePackages = "com.meifute.restructure.mmopenfeign")
public class MmauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmauthApplication.class, args);
    }

}
