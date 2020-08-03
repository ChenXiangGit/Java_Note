package com.meifute.restructure.mmuser.service;

import com.meifute.restructure.mmopenfeign.domain.user.entity.UserTest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-02
 */
public interface IUserTestService extends IService<UserTest> {


    Boolean testSeata();

    Boolean testRedisson();

}
