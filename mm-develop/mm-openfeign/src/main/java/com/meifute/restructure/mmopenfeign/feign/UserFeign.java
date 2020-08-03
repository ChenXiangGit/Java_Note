package com.meifute.restructure.mmopenfeign.feign;

import com.meifute.restructure.mmopenfeign.domain.LoginUser;
import com.meifute.restructure.mmopenfeign.domain.user.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther liuliang
 * @date 2020/4/3 4:05 PM
 */
@FeignClient(name = "mm-user")
public interface UserFeign {

    @GetMapping("/user/implement/get/user/by/username/only/pre/token")
    LoginUser getUserByUserName(@RequestParam("username") String username);


}
