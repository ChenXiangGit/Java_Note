package com.meifute.restructure.mmopenfeign.util;

import com.meifute.restructure.mmopenfeign.util.constant.UaaConstant;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    public static String getToken() {
        ServletRequestAttributes servletRequestAttributes = null;
        servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        RequestContextHolder.setRequestAttributes(servletRequestAttributes, true);
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String header = request.getHeader(UaaConstant.Authorization);

        String token = StringUtil.isBlank(StringUtil.substringAfter(header, OAuth2AccessToken.BEARER_TYPE + " ")) ? request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) : StringUtil.substringAfter(header, OAuth2AccessToken.BEARER_TYPE + " ");

        token = StringUtil.isBlank(request.getHeader(UaaConstant.TOKEN_HEADER)) ? token : request.getHeader(UaaConstant.TOKEN_HEADER);

        return token;

    }

}
