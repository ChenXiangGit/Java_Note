package com.eshop.microauth.service;

import com.eshop.microauth.dao.UserDao;
import com.eshop.microauth.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {

        ArrayList<UserDto> userDaos = new ArrayList<>();
        userDaos.add(UserDto.builder().username("a").mobile("1").build());
        userDaos.add(UserDto.builder().username("a").mobile("2").build());
        userDaos.add(UserDto.builder().username("b").mobile("3").build());
        userDaos.add(UserDto.builder().username("c").mobile("4").build());

        Map<String, List<UserDto>> skuCodeGroupBySkuCode = userDaos.stream().collect(Collectors.groupingBy(UserDto::getUsername));

        System.out.println(skuCodeGroupBySkuCode);
    }
}