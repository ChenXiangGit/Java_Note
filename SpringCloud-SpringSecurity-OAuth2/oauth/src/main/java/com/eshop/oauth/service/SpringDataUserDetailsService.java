package com.eshop.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HashMap<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("zhangsan",passwordEncoder.encode("123"));
        userInfoMap.put("lisi",passwordEncoder.encode("456"));
        userInfoMap.put("wangwu",passwordEncoder.encode("567"));

        String password = userInfoMap.get(username);
        String[] permissionArray = new String[]{"p1"};
        if (password == null)  return null;
        if ("zhangsan".equals(username)){
            permissionArray = new String[]{"p1","p3"};
        }

        UserDetails userDetails = User.withUsername(username).password(password).authorities(permissionArray).build();
        return userDetails;
    }
}