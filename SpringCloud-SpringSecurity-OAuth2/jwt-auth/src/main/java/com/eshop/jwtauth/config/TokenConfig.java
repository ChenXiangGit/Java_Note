package com.eshop.jwtauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    private static final String SIGNING_KEY = "haha88";
    // 令牌存储策略
    @Bean
    public TokenStore tokenStore()
    {
        // Jwt令牌存储方案
        return new JwtTokenStore(assessTokenConverter());
    }
    @Bean
    @Primary
    public JwtAccessTokenConverter assessTokenConverter()
    {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);//
        return converter;
    }
}
