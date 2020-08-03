package com.meifute.restructure.mmopenfeign.config;

import com.meifute.restructure.mmopenfeign.util.TokenUtil;
import com.meifute.restructure.mmopenfeign.util.constant.UaaConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 * feign拦截器
 */
@Configuration
public class FeignInterceptorConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {

            @Override
            public void apply(RequestTemplate template) {
                //传递token
                //使用feign client访问别的微服务时，将accessToken header
                //cfg.anyRequest().permitAll() 非强制校验token
                String token = TokenUtil.getToken();
                if (StringUtils.isNotBlank(token)) {
                    template.header(UaaConstant.Authorization, OAuth2AccessToken.BEARER_TYPE + " " + token);
                }

            }
        };

        return requestInterceptor;
    }
}
