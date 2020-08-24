package com.eshop.microorder.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * @ClassName: UserUtil
 * @Description:
 * @Author: Chen
 * @Date: 2020/8/6 15:28
 * @Version: 1.0
 */
public class UserUtil {


    public static String getCurrentOperatorInfo(){
        HttpServletRequest httpRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String header = httpRequest.getHeader("json-token");
        return EncryptUtil.decodeUTF8StringBase64(header);
    }

}