package com.meifute.restructure.mmauth.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * create by liuliang
 * on 2019-09-12  14:38
 * 资源服务器
 *
 */

@Configuration
@EnableResourceServer
//@Order(6)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "test";


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.requestMatcher(new OAuth2RequestedMatcher())
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/check_token",
                        "/**/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "swagger-resources/configuration/ui",
                        "/doc.html",
                        "/*.html",
                        "/webjars/**",
                        "/oauth/user/token").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/token").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .anyRequest().authenticated()
        ;
    }


    /**
     * 定义OAuth2请求匹配器
     */
    private static class OAuth2RequestedMatcher implements RequestMatcher {

        private AntPathMatcher antPathMatcher = new AntPathMatcher();

        @Override
        public boolean matches(HttpServletRequest request) {


            // 请求参数中包含access_token参数
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return true;
            }

            // 头部的Authorization值以Bearer开头
            String auth = request.getHeader("Authorization");
            if (auth != null) {
                if (auth.startsWith(OAuth2AccessToken.BEARER_TYPE)) {
                    return true;
                }
            }
            if (antPathMatcher.match(request.getRequestURI(), "/oauth/userinfo")) {
                return true;
            }
            if (antPathMatcher.match(request.getRequestURI(), "/oauth/remove/token")) {
                return true;
            }
            if (antPathMatcher.match(request.getRequestURI(), "/oauth/get/token")) {
                return true;
            }
            if (antPathMatcher.match(request.getRequestURI(), "/oauth/refresh/token")) {
                return true;
            }

            if (antPathMatcher.match(request.getRequestURI(), "/oauth/token/list")) {
                return true;
            }

            if (antPathMatcher.match("/clients/**", request.getRequestURI())) {
                return true;
            }

            if (antPathMatcher.match("/services/**", request.getRequestURI())) {
                return true;
            }
            if (antPathMatcher.match("/redis/**", request.getRequestURI())) {
                return true;
            }


            //判断来源请求是否包含oauth2授权信息,这里授权信息来源可能是头部的Authorization值以Bearer开头,或者是请求参数中包含access_token参数,满足其中一个则匹配成功
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token") != null;
            return haveOauth2Token || haveAccessToken;
        }
    }
}
