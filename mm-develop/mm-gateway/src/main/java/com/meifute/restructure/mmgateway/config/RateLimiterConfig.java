package com.meifute.restructure.mmgateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @auther liuliang
 * @date 2020/3/12 2:07 PM
 */
@Configuration
@Slf4j
public class RateLimiterConfig {

    @Bean(name = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange ->
             Mono.just(exchange.getRequest().getPath().value());
    }

}
