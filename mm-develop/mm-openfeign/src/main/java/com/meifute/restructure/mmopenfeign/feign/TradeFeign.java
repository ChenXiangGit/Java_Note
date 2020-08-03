package com.meifute.restructure.mmopenfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther liuliang
 * @date 2020/3/2 8:02 PM
 */
@FeignClient(name = "mm-trade")
public interface TradeFeign {

    @GetMapping("/trade/implement/test")
    void test();

}
