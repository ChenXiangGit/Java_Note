package com.meifute.restructure.mmsearch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meifute.restructure.mmopenfeign.domain.search.entity.SearchDemoEntity;
import com.meifute.restructure.mmopenfeign.domain.user.entity.UserTest;

/**
 * @author lizz
 * @date 2020/4/8 11:22
 */
public interface ISearchDemoService extends IService<SearchDemoEntity> {

    void create(SearchDemoEntity entity);

    SearchDemoEntity query(String id);

    void delete(String id);

    void update(SearchDemoEntity entity);


    SearchDemoEntity demo(String id);

    void testSeata(String name);
}
