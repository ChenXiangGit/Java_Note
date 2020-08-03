package com.meifute.restructure.mmtrade.controller.implement;

import com.meifute.restructure.mmopenfeign.feign.TradeFeign;
import com.meifute.restructure.mmtrade.service.IOrderTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther liuliang
 * @date 2020/4/2 2:21 PM
 */
@Slf4j
@RestController
@RequestMapping("/trade/implement")
public class TradeImplementController  implements TradeFeign {

    @Autowired
    private IOrderTestService orderTestService;

    @Override
    @GetMapping("/test")
    public void test() {
        log.info("=====test=====");
        orderTestService.testSeata();
    }
}
