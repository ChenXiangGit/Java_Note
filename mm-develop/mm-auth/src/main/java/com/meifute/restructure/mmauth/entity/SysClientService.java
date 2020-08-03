package com.meifute.restructure.mmauth.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="SysClientService对象", description="")
public class SysClientService implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "应用标识")
    @TableId("clientId")
    private Integer clientId;

    @ApiModelProperty(value = "服务权限标识")
    @TableField("serviceId")
    private Integer serviceId;


}
