package com.meifute.restructure.mmtrade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@MapperScan("com.meifute.restructure.mmtrade.mapper")
@EnableFeignClients(basePackages = "com.meifute.restructure.mmopenfeign")
@SpringBootApplication(scanBasePackages={"com.meifute.restructure.mmtrade","com.meifute.restructure.mmopenfeign.config"})
public class MmTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmTradeApplication.class, args);
    }

}
