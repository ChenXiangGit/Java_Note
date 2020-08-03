package com.meifute.restructure.mmopenfeign.domain.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户对象
 *
 * @author liang.liu
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysUser对象", description = "")
public class SysUser extends Model<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    @TableField("headImgUrl")
    private String headImgUrl;

    private String phone;

    private Boolean sex;

    private Boolean enabled;

    private String type;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("updateTime")
    private LocalDateTime updateTime;


    @TableField(exist = false)
    private List<SysRole> roles;

    @TableField(exist = false)
    private String roleId;

    @TableField(exist = false)
    private String oldPassword;
    @TableField(exist = false)
    private String newPassword;

}
