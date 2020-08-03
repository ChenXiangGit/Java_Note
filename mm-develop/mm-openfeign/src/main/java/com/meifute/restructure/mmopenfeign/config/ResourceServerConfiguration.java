package com.meifute.restructure.mmopenfeign.config;

import com.meifute.restructure.mmopenfeign.util.constant.WhiteListConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * create by liuliang
 * on 2019-09-12  14:38
 * 资源服务器
 */

@Configuration
@EnableResourceServer
@Order(1)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "test";


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        for (String au : WhiteListConstant.getAllWhite()) {
            http.authorizeRequests().antMatchers(au).permitAll();
        }
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.requestMatcher(new OAuth2RequestedMatcher());
    }


    /**
     * 定义OAuth2请求匹配器
     */
    private static class OAuth2RequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            //判断来源请求是否包含oauth2授权信息,这里授权信息来源可能是头部的Authorization值以Bearer开头,或者是请求参数中包含access_token参数,满足其中一个则匹配成功
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token") != null;
            return haveOauth2Token || haveAccessToken;
        }
    }


}
