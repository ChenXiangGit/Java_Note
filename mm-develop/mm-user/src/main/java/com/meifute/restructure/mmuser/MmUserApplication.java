package com.meifute.restructure.mmuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@MapperScan("com.meifute.restructure.mmuser.mapper")
@EnableFeignClients(basePackages = "com.meifute.restructure.mmopenfeign")
@SpringBootApplication(scanBasePackages={"com.meifute.restructure.mmuser","com.meifute.restructure.mmopenfeign.config"})
public class MmUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmUserApplication.class, args);
    }

}
