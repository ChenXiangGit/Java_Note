package com.eshop.microgateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ResouceServerConfig  {

    public static final String RESOURCE_ID = "res1";

    public static final  String checkTokenEndpointUrl = "http://micro-auth/auth/oauth/check_token" ;

    @Configuration
    @EnableResourceServer
    @Order(999)
    public class BGWServerConfig extends ResourceServerConfigurerAdapter {
//        @Autowired
//        private TokenStore tokenStore;

        @Autowired
        RestTemplate restTemplate;

        @Bean
        public ResourceServerTokenServices remoteTokenServices(){
            RemoteTokenServices service = new RemoteTokenServices();
            service.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
            service.setClientId("c1");
            service.setClientSecret("secret");
            service.setRestTemplate(restTemplate);
            return service;
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources.tokenServices(remoteTokenServices()).resourceId(RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
//            List<Permission> listPermission = permissionMapper.findAllPermission();
//            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http
//                    .authorizeRequests();
//            for (Permission permission : listPermission) {
//                authorizeRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
//            }
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/auth/**").permitAll()
                    .antMatchers("/order/r/r1").hasAuthority("p1")
                    .antMatchers("/order/r/r2").hasAuthority("p2")
                    .antMatchers("/order/r/r3").hasAuthority("p3")
                    .antMatchers("/order/r/r4").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic();
        }
    }

    //uaa资源服务配置
//    @Configuration
//    @EnableResourceServer
//    @Order(666)
//    public class authServerConfig extends ResourceServerConfigurerAdapter {
////        @Autowired
////        private TokenStore tokenStore;
//
//        @Autowired
//        RestTemplate restTemplate;
//
//        @Bean
//        public ResourceServerTokenServices authTokenServices(){
//            RemoteTokenServices service = new RemoteTokenServices();
//            service.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
//            service.setClientId("c1");
//            service.setClientSecret("secret");
//            service.setRestTemplate(restTemplate);
//            return service;
//        }
//
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources){
//            resources.tokenServices(authTokenServices()).resourceId(RESOURCE_ID).stateless(true);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().antMatchers("/auth/**").permitAll();
//        }
//    }
//
//
//    //order资源
//    //uaa资源服务配置
//    @Configuration
//    @EnableResourceServer
//    @Order(666)
//    public class OrderServerConfig extends ResourceServerConfigurerAdapter {
////        @Autowired
////        private TokenStore tokenStore;
//
//        @Autowired
//        RestTemplate restTemplate;
//
//        @Bean
//        public ResourceServerTokenServices orderTokenServices(){
//            RemoteTokenServices service = new RemoteTokenServices();
//            service.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
//            service.setClientId("c1");
//            service.setClientSecret("secret");
//            service.setRestTemplate(restTemplate);
//            return service;
//        }
//
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources){
//            resources.tokenServices(orderTokenServices()).resourceId(RESOURCE_ID).stateless(true);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().antMatchers("/order/r/r4").permitAll();
//        }
//    }

//    @Configuration
//    @EnableResourceServer
//    @Order(666)
//    public class UserServerConfig extends ResourceServerConfigurerAdapter {
////        @Autowired
////        private TokenStore tokenStore;
//
//        @Autowired
//        RestTemplate restTemplate;
//
//        @Bean
//        public ResourceServerTokenServices userTokenServices(){
//            RemoteTokenServices service = new RemoteTokenServices();
//            service.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
//            service.setClientId("c1");
//            service.setClientSecret("secret");
//            service.setRestTemplate(restTemplate);
//            return service;
//        }
//
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources){
//            resources.tokenServices(userTokenServices()).resourceId(RESOURCE_ID).stateless(true);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().antMatchers("/user/**").permitAll();
//        }
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
