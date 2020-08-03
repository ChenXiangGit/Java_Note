**本地项目启动步骤**

    1.git clone https://gitlab.meifute.com/restructure/mm.git -b develop
    
    2.主目录下打包项目:mvn clean install
    
    3.启动nacos:
        cd mm-nacos/bin
        sh startup.sh -m standalone
        
    4.启动seata
        cd mm-seata/bin
        sh seata-server.sh -p 8091 -m file
        （注意:若第一次启动，需要建好表,初始化nacos脚本等，具体可以参照[seata官网](https://seata.io/zh-cn/docs/ops/deploy-guide-beginner.html)）
        
    5.常规方式启动gateway/auth/job/user/trade/report等 （顺序无所谓，但是得启动gateway和auth）

**总述**

    由于项目越来越多，功能日益复杂，于是重构项目。

    项目基于Springcloud G版本，注册中心和配置中心使用的是springcloud nacos1.2 版本

    网关使用springcloud-gateway 一键式限流，熔断，降级，灰度发布（我们暂时其它方式灰度发布）

    分布式事务使用阿里开源框架seata1.1版本 目前主要使用其中的AT.TCC模式

    分布式锁使用分布式Redisson,自定义注解以及开发者可以自主lock.unlock,简单方便

    使用xxl-job完成分布式任务调度

    dao层框架一如既往的使用mybatis-plus，不过版本有所升级（3.1版本）


   


**分述**


    1. 关于规范 
       具体规范参考数据《阿里规范文档》
    
    2. 关于启动流程
        固定顺序: nacos->seata->gateway->auth
        其他: 顺序随意
    
    3. 关于gateway 
        gateway集网关路由转发/限流/熔断/降级/认证于一体
    
    4.关于oauth2.0
        
        对于oauth2.0，要明确oauth-server/oauth-client的概念
        本项目里面，mm-auth就是 oauth-server,其他使用了oauth2认证的模块就是oauth-client
        
        获取client_id,client_secret 方式:
            为了方便后续开放client_id/client_secret,项目将数据存入auth模块的oauth_client_details表中，
            在auth模块初始化的时候，会刷到redis里面。所以取client_id/client_secret可以从数据库取，也
            可以从redis取,若是新加的client_id/client_secret，需要重新刷一遍rdis即可
            
        获取token方式:
            打开knife4j -> auth pai -> Oauth API -> 用户名密码获取token 或其他方式
            
        
    5. 关于seata
        seata使用很简单，在需要全局事务的方法上加上注解@GlobalTransactional即可。事务参与放可以不用加任何注解。
        seata原理:可以参照seata官网
    
    6. 关于mybatis-plus
        CodeGenerator 是代码生成器
        默认下划线转驼峰
        deleted是逻辑删除字段（AOP已控制好）
        vesion是版本号（AOP已控制好）
    
    7. 关于redission分布式锁
        redission 专为分布式而生，这里自定义了分布式注解@DistributedLock,也可以手动lock/unlock
        特别注意：@DistributedLock的value一定要有值，没有值会产生全局锁，导致系统贼慢！！可以视为写bug
        
        
      

