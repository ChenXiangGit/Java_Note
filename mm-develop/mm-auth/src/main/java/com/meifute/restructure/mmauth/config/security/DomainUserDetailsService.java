package com.meifute.restructure.mmauth.config.security;

import com.meifute.restructure.mmopenfeign.domain.LoginUser;
import com.meifute.restructure.mmopenfeign.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by liuliang
 * on 2019/6/18
 */
@Component
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserFeign userFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser user = userFeign.getUserByUserName(username);
        log.info("用户{}登陆成功！",user);
        return user;
    }


}
