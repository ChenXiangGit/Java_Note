package com.meifute.restructure.mmauth.controller;


import cn.hutool.db.PageResult;
import com.meifute.restructure.mmauth.entity.OauthClientDetails;
import com.meifute.restructure.mmauth.service.impl.OauthClientDetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liang.liu
 * @since 2020-04-03
 */
@Api(tags = "CLIENT API")
@RestController
@RequestMapping("/mmauth/oauth-client-details")
public class OauthClientDetailsController {


    @Autowired
    private OauthClientDetailsServiceImpl sysClientService;


    @PostMapping
    @ApiOperation(value = "应用列表")
    @PreAuthorize("hasAuthority('client:get/clients')")
//    @LogAnnotation(module="auth-server",recordRequestParam=false)
    public PageResult<OauthClientDetails> listRoles(@RequestBody OauthClientDetails params) {
//        return sysClientService.page(null,new QueryWrapper<>()) ;
        return null;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取应用")
    @PreAuthorize("hasAuthority('client:get/clients/{id}')")
//    @LogAnnotation(module="auth-server",recordRequestParam=false)
    public OauthClientDetails get(@PathVariable Long id) {
        return sysClientService.getById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "所有应用")
//    @LogAnnotation(module="auth-server",recordRequestParam=false)
    @PreAuthorize("hasAnyAuthority('client:get/clients')")
    public List<OauthClientDetails> roles() {
        return sysClientService.list();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('client:delete/clients')")
//    @LogAnnotation(module="auth-server",recordRequestParam=false)
    public void delete(@PathVariable Long id) {
        sysClientService.removeById(id);
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "保存或者修改应用")
    @PreAuthorize("hasAuthority('client:post/clients')")
    public Object saveOrUpdate(@RequestBody OauthClientDetails clientDto){
        return  sysClientService.saveOrUpdate(clientDto);
    }
//    @PutMapping("/updateEnabled")
//    @ApiOperation(value = "修改状态")
//    @PreAuthorize("hasAuthority('client:post/clients')")
////    @LogAnnotation(module="auth-server",recordRequestParam=false)
//    public Object updateEnabled(@RequestBody Map<String, Object> params){
//        return  sysClientService.updateEnabled(params);
//    }

}
