## SpringBoot 基础

#### 1	什么是SpringBoot？

​       SpringBoot 是一个快速开发的框架,能够快速的整合第三方框架，简化XML配置，全部采用注解形式，内置Tomcat容器,帮助开发者能够实现快速开发，SpringBoot的Web组件 默认集成SpringMVC框架。

#### 2	为什么要用SpringBoot？

Spring Boot的主要优点：(快速开发，简化配置，内置web容器)
为所有Spring开发者更快的入门
开箱即用，提供各种默认配置来简化项目配置
内嵌式容器简化Web项目
没有冗余代码生成和XML配置的要求

#### 3	SpringBoot启动方式

@SpringBootApplication 被 @Configuration、@EnableAutoConfiguration、@ComponentScan 注解所修饰，换言之 Springboot 提供了统一的注解来替代以上三个注解

#### 4	SpringBoot2.0新特性

1. Spring Boot 2是完全基于java8，这也就证明了java8已经被大家全面接受和普及， 虽然java9也已经发布， 但是java9的普及可能还需要一段时间，但是现在Spring Boot 2也同时对java9做了一些支持。 
2. http请求方面， 引入了Webflux， 他是基于Spring Webflux， 它是一个新的非堵塞函数式 Reactive Web 框架，可以用来建立异步的，非阻塞，事件驱动的服务，并且扩展性非常好。性能对比于之前的同步方式有了一定的提高 
3. db方面，默认引入了HikariCP，替代了之前的tomcat-pool作为底层的数据库连接池， 对比于tomcat-pool， HikariCP拥有更好的性能，总而言之就是提高了db的访问速度。 
4. redis方面， 默认引入了Lettuce, 替代了之前的jedis作为底层的redis链接方式， 同样Lettuce底层基于netty框架，使用异步的方式，访问redis，并且如果结合之前的Webflux, 可以达成请求的全异步， 同样对比于之前的jedis，统一了redis和redis-cluster的访问方式，简化了开发人员的使用方式，同时也提高了redis的访问速度 
5. es方面，默认也从之前的支持es2升级到了es5+, es5也出来了一段时间， 大部分的人应该也是通过自己实现来完成es5的对接， 现在springboot2也是进行了es5的支持。 Spring Boot 2 同时也加入了 对于OAuth 2.0的支持， 使得开发人员更加友好的和方面的使用spring-security来完成权限模块的开发. 	

#### 5	SpringBoot如何实现异步执行

启动加上@EnableAsync ,需要执行异步方法上加入	

@Async 在方法上加上@Async之后 底层使用多线程技术

#### 6	SpringBoot多数据源拆分的思路?

原理使用根据包名，加载不同的数据源

#### 7	SpringBoot多数据源事务如何管理?

使用springboot+jta+atomikos 分布式事物管理
Atomikos 是一个为Java平台提供增值服务的并且开源类事务管理器。

#### 8	SpringBoot性能如何优化

1. 扫包优化
2. JVM优化
3. servlet容器变成undertow

#### 9	SpringBoot启动流程?(需要完善)

1. run() 实例化SpringApplication,在构造器中调用initialize(),作用有两个：一是判断该应用是否是web应用，其二 设置初始化类和监听器集合。在META_INF下的spring.factories中可以看到相应的初始化类和监听器集合的信息。
2. StopWatch 记录启动时长，
3. 获取监听SpringApplicationRunListeners，开启监听
4. 根据配置参数类ApplicationArguments，创建可配置环境ConfigurableEnvironment
5. 创建并初始化 可配置应用上下文 ConfigurableApplicationContext
6. refreshContext(context) 刷新上下文，加载Spring相关的内容，完成启动。