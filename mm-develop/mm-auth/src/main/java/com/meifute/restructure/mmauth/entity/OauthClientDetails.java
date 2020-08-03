package com.meifute.restructure.mmauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OauthClientDetails对象", description="")
public class OauthClientDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "应用标识")
    private String clientId;

    @ApiModelProperty(value = "资源限定串(逗号分割)")
    private String resourceIds;

    @ApiModelProperty(value = "应用密钥(bcyt) 加密")
    private String clientSecret;

    @ApiModelProperty(value = "应用密钥(明文)")
    private String clientSecretStr;

    @ApiModelProperty(value = "范围")
    private String scope;

    @ApiModelProperty(value = "5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)")
    private String authorizedGrantTypes;

    @ApiModelProperty(value = "回调地址 ")
    private String webServerRedirectUri;

    @ApiModelProperty(value = "权限")
    private String authorities;

    @ApiModelProperty(value = "access_token有效期")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "refresh_token有效期")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "{}")
    private String additionalInformation;

    @ApiModelProperty(value = "是否自动授权 是-true")
    private String autoapprove;

    private Integer status;

    private Integer ifLimit;

    private Integer limitCount;


}
