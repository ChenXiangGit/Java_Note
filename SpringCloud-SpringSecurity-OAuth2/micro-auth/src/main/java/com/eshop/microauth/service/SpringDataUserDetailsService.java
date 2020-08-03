package com.eshop.microauth.service;

import com.eshop.microauth.dao.UserDao;
import com.eshop.microauth.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto bean = userDao.getUserByUsername(s);
        if (bean == null)
            return null;
        List<String> permissions = userDao.findPermissionByUserId(bean.getId());
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(bean.getUsername()).password(bean.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}