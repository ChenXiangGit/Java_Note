package com.meifute.restructure.mmoperate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@MapperScan("com.meifute.restructure.mmoperate.mapper")
@EnableFeignClients(basePackages = "com.meifute.restructure.mmopenfeign")
@SpringBootApplication(scanBasePackages={"com.meifute.restructure.mmoperate","com.meifute.restructure.mmopenfeign.config"})
public class MmOperateApplication {
    public static void main(String[] args) {
        SpringApplication.run(MmOperateApplication.class, args);
    }

}
