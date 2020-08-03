package com.meifute.restructure.mmopenfeign.util;

import com.meifute.restructure.mmopenfeign.domain.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @auther liuliang
 * @date 2020/4/13 10:39 AM
 *
 * oauth2 认证用户工具类
 */
public class SecurityUserUtil {


    /**
     * 获取当前登陆用户
     * @return
     */
    public static LoginUser getCurrentUser(){

        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return (LoginUser)principal;
    }


}
