package com.meifute.restructure.mmopenfeign.config.exception;


import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MessageConfiguration extends WebMvcConfigurerAdapter implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/message/exceptions.yml");//指定到待读的yml文件
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1000);
        return messageSource;
    }
}
