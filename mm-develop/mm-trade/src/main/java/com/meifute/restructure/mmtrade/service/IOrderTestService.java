package com.meifute.restructure.mmtrade.service;

import com.meifute.restructure.mmopenfeign.domain.trade.entity.OrderTest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-02
 */
public interface IOrderTestService extends IService<OrderTest> {


    Boolean testSeata();

}
