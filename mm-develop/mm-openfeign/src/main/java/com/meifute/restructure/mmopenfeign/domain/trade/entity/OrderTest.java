package com.meifute.restructure.mmopenfeign.domain.trade.entity;

import java.math.BigDecimal;
import com.meifute.restructure.mmopenfeign.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="OrderTest对象", description="")
public class OrderTest extends BaseEntity {

    @ApiModelProperty(value = "商品名称")
    private String itemName;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;


}
