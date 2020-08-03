package com.meifute.restructure.mmuser.mapper;

import com.meifute.restructure.mmopenfeign.domain.user.entity.SysPermission;
import com.meifute.restructure.mmopenfeign.domain.user.entity.SysRole;
import com.meifute.restructure.mmopenfeign.domain.user.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-03
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select r.* from sys_role_user ru inner join sys_role r on r.id = ru.roleId where ru.userId = #{userId}")
    Set<SysRole> findRolesByUserId(Long userId);


    Set<SysPermission> findPermissionsByRoleIds(@Param("roleIds") Set<Long> roleIds);


}
