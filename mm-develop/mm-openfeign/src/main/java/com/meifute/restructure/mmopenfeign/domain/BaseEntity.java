package com.meifute.restructure.mmopenfeign.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @auther liuliang
 * @date 2020/4/2 1:46 PM
 */
@Data
@ApiModel(value="基础父类对象")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty(value = "逻辑删除 0未删除",example = "0")
    private Integer deleted;

    @ApiModelProperty(value = "乐观锁控制字段:版本号",example = "1")
    private Integer version;

    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+0")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间 yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+0")
    private LocalDateTime updateDate;


    @ApiModelProperty(value = "分页当前页数（默认从0开始）",example = "0")
    @TableField(exist = false)
    protected Integer pageCurrent;

    @TableField(exist = false)
    @ApiModelProperty(value = "分页每页个数（默认20条）",example = "20")
    protected Integer pageSize;

}
