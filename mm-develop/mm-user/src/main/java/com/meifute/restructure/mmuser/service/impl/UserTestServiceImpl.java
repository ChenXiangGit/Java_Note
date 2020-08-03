package com.meifute.restructure.mmuser.service.impl;

import com.meifute.restructure.mmopenfeign.config.redisson.annotation.DistributedLock;
import com.meifute.restructure.mmopenfeign.feign.TradeFeign;
import com.meifute.restructure.mmopenfeign.domain.user.entity.UserTest;
import com.meifute.restructure.mmuser.mapper.UserTestMapper;
import com.meifute.restructure.mmuser.service.IUserTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-02
 */
@Slf4j
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements IUserTestService {

    @Autowired
    private TradeFeign tradeFeign;


    /**
     * seata 测试
     * @return
     */
    @Override
    @GlobalTransactional
    public Boolean testSeata() {
        UserTest userTest = this.getById(1);
        userTest.setAge(1);
        this.updateById(userTest);
        tradeFeign.test();
//        return true;
        throw new RuntimeException("seata测试异常");
    }

    @Override
    @DistributedLock
    public Boolean testRedisson() {

        log.info("我是执行逻辑....");

        return Boolean.TRUE;
    }
}
