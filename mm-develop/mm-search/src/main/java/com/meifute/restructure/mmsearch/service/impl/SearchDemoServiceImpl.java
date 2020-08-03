package com.meifute.restructure.mmsearch.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meifute.restructure.mmopenfeign.domain.search.entity.SearchDemoEntity;
import com.meifute.restructure.mmopenfeign.domain.user.entity.UserTest;
import com.meifute.restructure.mmopenfeign.feign.TradeFeign;
import com.meifute.restructure.mmsearch.mapper.SearchDemoMapper;
import com.meifute.restructure.mmsearch.service.ISearchDemoService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lizz
 * @date 2020/4/8 11:22
 */
@Service
@Slf4j
public class SearchDemoServiceImpl extends ServiceImpl<SearchDemoMapper,SearchDemoEntity> implements ISearchDemoService {


    @Resource
    private SearchDemoMapper searchDemoMapper;

    @Autowired
    private TradeFeign tradeFeign;


    @Override
    public void create(SearchDemoEntity entity) {
        searchDemoMapper.insert(entity);
    }

    @Override
    public SearchDemoEntity query(String id) {
        return searchDemoMapper.selectById(id);
    }

    @Override
    public void delete(String id) {
        searchDemoMapper.deleteById(id);
    }

    @Override
    public void update(SearchDemoEntity entity) {
        searchDemoMapper.updateById(entity);
    }

    @Override
    public SearchDemoEntity demo(String id) {
        return null;
    }

    @Override
    @GlobalTransactional
    public void testSeata(String name) {
        SearchDemoEntity entity = searchDemoMapper.selectById("1");
        log.info("=========entity{}",entity);
        entity.setSearchName(name);
        searchDemoMapper.updateById(entity);
        tradeFeign.test();
        throw new RuntimeException("=========出现异常==========");

    }
}
