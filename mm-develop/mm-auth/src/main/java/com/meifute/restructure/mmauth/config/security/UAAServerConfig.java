package com.meifute.restructure.mmauth.config.security;

import com.meifute.restructure.mmauth.config.RestTemplateConfig;
import com.meifute.restructure.mmauth.config.token.RedisClientDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;

/**
 * @auther liuliang
 * @date 2020/4/6 11:15 AM
 */

@Configuration
@SuppressWarnings("all")
@Import({RestTemplateConfig.class})
public class UAAServerConfig {


    /**
     * 声明 ClientDetails实现
     */
    @Bean
    public RedisClientDetailsService redisClientDetailsService(DataSource dataSource , RedisTemplate<String, Object> redisTemplate ) {
        RedisClientDetailsService clientDetailsService = new RedisClientDetailsService(dataSource);
        clientDetailsService.setRedisTemplate(redisTemplate);
        return clientDetailsService;
    }

}
