package com.meifute.restructure.mmuser.controller;


import com.meifute.restructure.mmopenfeign.domain.LoginUser;
import com.meifute.restructure.mmopenfeign.domain.user.entity.UserTest;
import com.meifute.restructure.mmopenfeign.util.SecurityUserUtil;
import com.meifute.restructure.mmuser.service.IUserTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/mmuser/user-test")
@Api(tags = "测试controller", value = "测试controller")
@Slf4j
public class UserTestController {

    @Autowired
    private IUserTestService userTestService;

    @ApiOperation("网关测试")
    @GetMapping("/gateway")
    public ResponseEntity<UserTest> testGateway(@RequestParam Long id){
        UserTest test = userTestService.getById(id);
        LoginUser currentUser = SecurityUserUtil.getCurrentUser();
        log.info("current:{}",currentUser);
        return ResponseEntity.ok(test);
    }

    @ApiOperation("seata测试")
    @GetMapping("/seata")
    public ResponseEntity testSeata(){
        return ResponseEntity.ok(userTestService.testSeata());
    }


    @ApiOperation("redisson测试")
    @GetMapping("/redisson")
    public ResponseEntity testRedisson(){
        return ResponseEntity.ok(userTestService.testRedisson());
    }

}
