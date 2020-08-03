package com.meifute.restructure.mmauth.entity;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务网关路由表
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysGatewayRoutes对象", description="服务网关路由表")
public class SysGatewayRoutes implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "uri路径")
    private String uri;

    @ApiModelProperty(value = "判定器")
    private String predicates;

    @ApiModelProperty(value = "过滤器")
    private String filters;

    @ApiModelProperty(value = "排序")
    private Integer order;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "删除标志 0 不删除 1 删除")
    @TableField("delFlag")
    private Integer delFlag;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("updateTime")
    private LocalDateTime updateTime;


}
