package com.meifute.restructure.mmauth.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @auther liuliang
 * @date 2020/3/17 7:03 PM
 */
@Component
public class LoginAuthenticationProvider  extends DaoAuthenticationProvider {


    @Autowired
    private DomainUserDetailsService userDetailsService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private void setUserDetailsService(){
        setUserDetailsService(userDetailsService);
    }

    @PostConstruct
    public void initProvider() {
        ReloadableResourceBundleMessageSource localMessageSource = new ReloadableResourceBundleMessageSource();
        localMessageSource.setBasenames("messages_zh_CN");
        messages = new MessageSourceAccessor(localMessageSource);
    }


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "用户名密码错误"));
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
            logger.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "用户名密码错误"));
        }
    }


}
