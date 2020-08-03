package com.meifute.restructure.mmuser.controller.implement;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meifute.restructure.mmopenfeign.domain.LoginUser;
import com.meifute.restructure.mmopenfeign.domain.user.entity.SysPermission;
import com.meifute.restructure.mmopenfeign.domain.user.entity.SysRole;
import com.meifute.restructure.mmopenfeign.domain.user.entity.SysUser;
import com.meifute.restructure.mmopenfeign.feign.UserFeign;
import com.meifute.restructure.mmuser.mapper.SysUserMapper;
import com.meifute.restructure.mmuser.service.ISysRoleUserService;
import com.meifute.restructure.mmuser.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @auther liuliang
 * @date 2020/4/2 2:21 PM
 */
@Slf4j
@RestController
@RequestMapping("/user/implement")
public class UserImplementController implements UserFeign {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysUserMapper userMapper;



    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @GetMapping("/get/user/by/username/only/pre/token")
    public LoginUser getUserByUserName(@RequestParam("username") String username){
        SysUser sysUser = userService.getOne(new QueryWrapper<SysUser>().eq("username", username));
        if (sysUser != null) {
            LoginUser loginUser = new LoginUser();
            BeanUtils.copyProperties(sysUser, loginUser);
            Set<SysRole> sysRoles = userMapper.findRolesByUserId(sysUser.getId());
            loginUser.setSysRoles(sysRoles);// 设置角色

            if (!CollectionUtils.isEmpty(sysRoles)) {
                Set<Long> roleIds = sysRoles.parallelStream().map(r -> r.getId()).collect(Collectors.toSet());
//                Set<SysPermission> sysPermissions = userMapper.findPermissionsByRoleIds(roleIds);
//                if (!CollectionUtils.isEmpty(sysPermissions)) {
//                    Set<String> permissions = sysPermissions.parallelStream().map(p -> p.getPermission())
//                            .collect(Collectors.toSet());
//                    loginUser.setPermissions(permissions);// 设置权限集合
//                }
            }
            return loginUser;
        }
        return null;
    }

}
