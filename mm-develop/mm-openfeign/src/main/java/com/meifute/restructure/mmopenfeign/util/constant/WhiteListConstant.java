package com.meifute.restructure.mmopenfeign.util.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther liuliang
 * @date 2020/4/9 11:49 AM
 * <p>
 * 各模块白名单
 */
public class WhiteListConstant {


    //公共白名单
    public static String[] COMMON_WHITE = new String[]{
            "/**/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "swagger-resources/configuration/ui",
            "/doc.html",
            "/webjars/**",
            "/oauth/token"
    };


    //用户中心白名单
    public static String[] USER_WHITE = new String[]{
            "/user/implement/get/user/by/username/only/pre/token"
    };


    //交易中心白名单
    public static String[] TRADE_WHITE = new String[]{

    };

    //搜索中心白名单
    public static String[] SEARCH_WHITE = new String[]{

    };


    //获取所有白名单
    public static String[] getAllWhite() {
        Set<String> set = new HashSet<String>();

        set = getOneWhite(set, COMMON_WHITE);
        set = getOneWhite(set, USER_WHITE);
        set = getOneWhite(set, TRADE_WHITE);
        set = getOneWhite(set, SEARCH_WHITE);
        String[] result = {};

        return set.toArray(result);
    }


    public static Set<String> getOneWhite(Set<String> set, String[] whites) {
        for (String white : whites) {
            set.add(white);
        }
        return set;
    }

}
