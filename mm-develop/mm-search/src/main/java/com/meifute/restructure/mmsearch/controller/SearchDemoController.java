package com.meifute.restructure.mmsearch.controller;

import com.meifute.restructure.mmopenfeign.domain.search.entity.SearchDemoEntity;
import com.meifute.restructure.mmsearch.service.ISearchDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lizz
 * @date 2020/4/8 11:07
 */
@RestController
@RequestMapping("/mmsearch/demo")
public class SearchDemoController {


    @Autowired
    private ISearchDemoService searchDemoService;

    @GetMapping("/create")
    public ResponseEntity create(SearchDemoEntity entity){
        searchDemoService.create(entity);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/get")
    public ResponseEntity get(String id){
        return ResponseEntity.ok(searchDemoService.query(id));
    }

    @GetMapping("/test")
    public ResponseEntity test(String name){
        return ResponseEntity.ok("hello " + name + UUID.randomUUID().toString());
    }

    @GetMapping("/test/seata")
    public ResponseEntity testSeata(String name){
        searchDemoService.testSeata(name);
        return ResponseEntity.ok("ok");
    }


}
