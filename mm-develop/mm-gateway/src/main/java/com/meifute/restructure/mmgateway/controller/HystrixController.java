package com.meifute.restructure.mmgateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther liuliang
 * @date 2020/3/12 4:54 PM
 */
@RestController
public class HystrixController {

    @RequestMapping("/userFallback")
    public ResponseEntity userFallback(){
        return new ResponseEntity("user服务器在开小差",HttpStatus.OK);
    }


}
