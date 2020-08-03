package com.meifute.restructure.mmsearch.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lizz
 * @date 2020/4/8 16:02
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {


    @Bean(value = "searchApi")
    @Order(value = 1)
    public Docket groupRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.meifute.restructure.mmsearch.controller"))
                .paths(PathSelectors.any()).build();
    }


    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("搜索中心 接口说明 文档")
                .description("<div style='font-size:14px;color:red;'>关于搜索中心接口说明</div>")
                .termsOfServiceUrl("http://www.meifute.com/")
                .version("1.0")
                .build();
    }

}
