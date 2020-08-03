package com.meifute.restructure.mmsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.meifute.restructure.mmsearch.mapper")
@EnableFeignClients(basePackages = "com.meifute.restructure.mmopenfeign")
public class MmSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmSearchApplication.class, args);
    }

}
