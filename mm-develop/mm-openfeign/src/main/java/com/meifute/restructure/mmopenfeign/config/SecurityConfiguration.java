package com.meifute.restructure.mmopenfeign.config;

import com.meifute.restructure.mmopenfeign.util.constant.WhiteListConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by liuliang
 * on 2019/6/19
 */

@Configuration
@EnableWebSecurity
//开启权限认证
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * http安全配置
     *
     * @param http http安全对象
     * @throws Exception http安全异常信息
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                .authorizeRequests().antMatchers(WhiteListConstant.getAllWhite()).permitAll().anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // 禁用csrf
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //allow Swagger URL to be accessed without authentication
        web.ignoring().antMatchers(WhiteListConstant.getAllWhite());
    }

    @Bean
    public TokenStore tokenStore() {
        return new MmRedisTokenStore(redisConnectionFactory);
    }


}