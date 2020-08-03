package com.eshop.order.config;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

//@Configuration
public class TokenConfig{

//    @Bean
    public TokenStore tokenStore()
    {
        return new InMemoryTokenStore();
    }

}
