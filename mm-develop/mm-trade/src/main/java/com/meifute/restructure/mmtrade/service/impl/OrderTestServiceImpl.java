package com.meifute.restructure.mmtrade.service.impl;

import com.meifute.restructure.mmopenfeign.domain.trade.entity.OrderTest;
import com.meifute.restructure.mmtrade.mapper.OrderTestMapper;
import com.meifute.restructure.mmtrade.service.IOrderTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-02
 */
@Service
public class OrderTestServiceImpl extends ServiceImpl<OrderTestMapper, OrderTest> implements IOrderTestService {

    @Override
    public Boolean testSeata() {

        OrderTest orderTest = this.getById(1);
        orderTest.setAmount(BigDecimal.ONE);
        boolean b = this.updateById(orderTest);


        return b;
    }
}
