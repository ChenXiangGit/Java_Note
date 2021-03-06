## Spring Cloud 基础

#### 1	网站架构演变演变过程？

**传统架构->分布式架构->SOA架构->微服务架构**

1. **传统架构**
   		传统的SSH架构，分为三层架构 web控制层、业务逻辑层、数据库访问层。 传统架构也就是单点应用，就是大家在刚开始初学**JavaEE**技术的时候SSH架构或者**SSM**架构，业 务没有进行拆分，都写同一个项目工程里面，一般是适合于个人或者是小团队开发。这种架构模式，一旦有一个模块导致服务不可用，可能会影响整个项目。

2. **分布式架构**
         分布式架构基于传统架构演变过来，将传统的单体项目以项目模块进行拆分，拆分为会员项目、订单项目、支付项目、优惠券项目等，从而降低耦合度，这种项目架构模式慢慢开始适合于互联网公司规模人数开发。

3. **SOA架构**
         SOA架构代表面向与服务架构，俗称服务化，通俗的理解为面向与业务逻辑层开发，将共同的业务逻辑抽取出来形成一个服务，提供给其他服务接口进行调用，服务与服务之间调用使用RPC远程技术。
         SOA架构特点:
              a）SOA架构中通常使用XML方式实现通讯，在高并发情况下XML比较冗余会带来极大的影响，所以最后微服务架构中采用JSON替代xml方式
              b）SOA架构的底层实现通过WebService和ESB（xml与中间件混合物），Web Service技术是SOA服务化的一种实现方式，WebService底层采用soap协议进行通讯，soap协议就是Http或者是 Https通道传输XML数据实现的协议。

4. **微服务架构**
        基于SOA架构演变过来的
        在传统的Web Service架构中有如下问题:
            1.依赖中心化服务发现机制
            2.使用Soap通讯协议，通常使用XML格式来序列化通讯数据，xml格式非常重，较占宽带传输。
            3.服务化管理和治理设施不完善

   

#### 2	什么是SOA架构？

​       SOA架构代表面向与服务架构，俗称服务化，通俗的理解为面向与业务逻辑层开发，将共同的业务逻辑抽取出来形成一个服务，提供给其他服务接口进行调用，服务与服务之间调用使用RPC远程技术。

#### 3	什么是微服务架构？

​      微服务架是从SOA架构演变过来，比SOA架构粒度会更加精细，让专业的人去做专业的事情（专注），目的提高效率，每个服务于服务之间互不影响，微服务架构中，每个服务必须独立部署，互不影响，微服务架构更加体现轻巧、轻量级，是适合于互联网公司敏捷开发。

#### 4	微服务架构与SOA架构区别？

1. 微服务架构基于 SOA架构 演变过来，继承 SOA架构的优点，在微服务架构中去除 SOA 架构中的 ESB 消息总线，采用 http+json（restful）进行传输。

2. 微服务架构比 SOA 架构粒度会更加精细，每个服务于服务之间互不影响，微服务架构中，每个服务必须独立部署，微服务架构更加轻巧，轻量级。

3. SOA 架构中可能数据库存储会发生共享，微服务强调独每个服务都是单独数据库，保证每个服务于服务之间互不影响。

4. 项目体现特征微服务架构比 SOA 架构更加适合与互联网公司敏捷开发、快速迭代版本，因为粒度非常精细。

   

#### 5	什么是Spring Cloud？

​       Spring Cloud是基于Spring Boot基础之上开发的微服务框架，Spring Cloud是一套目前非常完整的微服务解决方案框架，其内容包含服务治理、注册中心、配置管理、断路器、智能路由、微代理、控制总线、全局锁、分布式会话等。

#### 6	为什么要使用Spring Cloud？

​       因为Spring Cloud出现,对微服务技术提供了非常大的帮助，因为Spring Cloud 提供了一套完整的微服务解决方案，不像其他框架只是解决了微服务中某个问题。
​      a）服务治理: 阿里巴巴开源的Dubbo和当当网在其基础上扩展的Dubbox、Eureka、Apache 的Consul等
​      b）分布式配置中心: 百度的disconf、Netfix的Archaius、360的QConf、SpringCloud、携程的阿波罗。
​      c）分布式任务:xxl-job、elastic-job、Spring Cloud的task等。
​      d）服务跟踪:京东的hyra、springcloud的sleuth等

#### 7	Spring Cloud服务注册发现原理？

​       在服务注册与发现中，有一个注册中心，当服务器启动的时候，会把当前自己服务器的信息 比如 服务地址通讯地址等以别名方式注册到注册中心上。另一方（消费者|服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，让后在实现RPC调用。

#### 8	Spring Cloud 支持那些注册中心

**Consul   Eureka   Zookeeper**

#### 9	如果Eureka闭源了，可以通过什么注册中心替代Eureka呢？

Consul 、ZK

#### 10	谈谈你对微服务服务治理的思想？

管理服务与服务之间的依赖关系，实现本地负载均衡，服务注册和发现。

#### 11	Eureka如何实现高可用？

使用集群，主从热备

#### 12	@Load Balanced注解的作用？

采用轮训策略，实现本地负载均衡。

#### 13	Nginx与Ribbon的区别？

**服务器端负载均衡 Nginx：**
Nginx 是客户端所有请求统一交给 Nginx ，由 Nginx 进行实现负载均衡请求转发，属于服务器端负载均衡。既请求由 Nginx 服务器端进行转发。

**客户端负载均衡 Ribbon：**
Ribbon是从 eureka 注册中心服务器端上获取服务注册信息列表，缓存到本地，然后在本地实现轮训负载均衡策略。既在客户端实现负载均衡。

**总结：**Nginx 适合于服务器端实现负载均衡 比如 Tomcat ，Ribbon 适合与在微服务中 RPC 远程调用实现本地服务负载均衡，比如 Dubbo、Spring Cloud 中都是采用本地负载均衡。

#### 14	Ribbon底层实现原理

Ribbon 是从 eureka 注册中心服务器端上获取服务注册信息列表，缓存到本地，然后在本地实现轮训负载均衡策略。既在客户端实现负载均衡。自动实现故障转移。

#### 15	Spring Cloud有几种调用接口方式

**Fegin客户端或者rest**

#### 16	DiscoveryClient的作用

Discovery Client接口 可以获取注册中心上的实例信息。 Spring Cloud alibaba 的注册中心组建Nacos也实现了改接口，用于服务发现。

#### 17	服务雪崩效应产生的原因

服务雪崩效应产生与服务堆积在同一个线程池中，因为所有的请求都是同一个线程池进行处理，这时候如果在高并发情况下，所有的请求全部访问同一个接口，这时候可能会导致其他服务没有线程进行接受请求，这就是服务雪崩效应效应。

#### 18	谈谈Hystrix服务保护的原理

1. 服务降级 在高并发情况下，防止用户一直等待，使用服务降级方式(直接返回一个友好的提示给客户端，调用fallBack方法)，提高用户体验。
2. 服务熔断 熔断机制目的为了保护服务，在高并发的情况下，如果请求达到一定极限(可以自己设置阔值)如果流量超出了设置阈值，让后直接拒绝访问，保护当前服务。使用服务降级方式返回一个友好提示，服务熔断和服务降级一起使用。
3. 服务隔离:因为默认情况下，只有一个线程池会维护所有的服务接口，如果大量的请求访问同一个接口，达到tomcat 线程池默认极限，可能会导致其他服务无法访问。

#### 19	谈谈服务降级、熔断、服务隔离

1. **服务降级**。在高并发情况下，防止用户一直等待，使用服务降级方式(直接返回一个友好的提示给客户端，调用fallBack方法)，提高用户体验
2. **服务熔断**。熔断机制目的为了保护服务，在高并发的情况下，如果请求达到一定极限(可以自己设置阔值，默认是10)如果流量超出了设置阈值，让后直接拒绝访问，保护当前服务。使用服务降级方式返回一个友好提示，服务熔断和服务降级一起使用。
3. **服务隔离**。因为默认情况下，只有一个线程池会维护所有的服务接口，如果大量的请求访问同一个接口，达到tomcat 线程池默认极限，可能会导致其他服务无法访问。
   解决服务雪崩效应:使用服务隔离机制(线程池方式和信号量)，使用线程池方式实現隔离的原理:  相当于每个接口(服务)都有自己独立的线程池，因为每个线程池互不影响，这样的话就可以解决服务雪崩效应。
     线程池隔离:
     每个服务接口，都有自己独立的线程池，每个线程池互不影响。缺点：CPU占用率高。
     信号量隔离:
   使用一个原子计数器（或信号量）来记录当前有多少个线程在运行，当请求进来时先判断计数器的数值，若超过设置的最大线程个数则拒绝该请求，若不超过则通行，这时候计数器+1，请求返 回成功后计数器-1。

**服务降级**：Hystrix 在远程调用rpc接口的接口的时候，在超时时间内（Hystrix 默认是1S时间）没有返回信息，会走服务降级接口。在默认时间内没有拿到返回结果，就会走服务降级功能，可以吧超时时间设置的稍微长点。
Hystrix 默认开启线程池隔离方式，默认开启降级执行和熔断机制。服务隔离采取默认线程池隔离。

#### 20	分布式配置中心有那些框架？

**携程的阿波罗**，有专门的图形界面可管理配置文件，存放在数据库中。

Spring Cloud **Config**没有后台可管理分布式配置中心，配置文件存放在版本控制器里面。

**Zookeeper** 实现分布式配置中心，持久节点+事件通知

Spring Cloud Alibaba 的**Nacos**。

#### 21	分布式配置中心的作用？

当一个系统中的配置文件发生改变的时候，我们需要重新启动该服务，才能使得新的配置文件生效，Spring Cloud Config可以实现微服务中的所有系统的配置文件的统一管理，而且还可以实现当配置文件发生变化的时候，系统会自动更新获取新的配置。

Spring Cloud Config 可以实现实时刷新吗？

默认情况下是不会实时刷新的， 

**手动刷新**：需要人工调用接口，读取最新的配置文件。（监控中心）

**自动刷新**：实时刷新采用Spring Cloud Bus消息总线。

#### 22	什么是网关?

客户端请求统一先请求到网关服务器，再由网关服务器转发请求到相应的服务。

#### 23	网关的作用是什么

可以拦截客户端所有请求，对请求进行**权限控制**，**负载均衡**，**日志管理**，接口调用**监控**的等。
（负载均衡、路由转发、日志、权限控制、监控等）。

   1，网关对所有会话进行拦截

   2，网关安全控制，统一异常管理、XXS、SQL注入等。

   3，权限控制、性能监控、黑名单和白名单、日志打印

#### 24	网关与过滤器有什么区别

**过滤器**：是拦截单个tomcat服务器的请求
**网关**：拦截微服务所有请求。

#### 25	常用网关框架有那些？

Kongkong Nginx + Lua 二次开发
Zull 和 Gateway Spring Cloud 推荐的组件

#### 26	Zuul与Nginx有什么区别？

Nginx是采用服务器负载均衡进行转发

Zuul依赖Ribbon和eureka实现本地负载均衡转发

相对来说Nginx功能比Zuul功能更加强大，能够整合其他语言比如lua脚本实现强大的功能，

同时Nginx可以更好的抗高并发，Zuul网关适用于请求过滤和拦截等。

都可以实现负载均衡、俺想代理、过滤请求、实现网关效果。

不同点：nginx采用C编写 Zull采用java编写。

Zull实现负载均衡：采用ribbon+eureka实现本地负载均衡。

Nginx负载均衡：采用服务器端实现负载均衡。

Nginx比Zull功能更加强大，因为Nginx整合一些脚本语言（Nginx+Lua）

Nginx更适合服务器端做负载均衡

Zull适合微服务中实现网关，而且使用的技术是java语言

最好方案：Nginx+Zull实现网关效果

Nginx作用实现反向代理

Zull对微服务实现网关拦截

#### 27	ZuulFilter常用有那些方法？

**filterType**() 过滤器类型 pre 表示在 请求之前进行拦截return "pre";
**filterOrder**()过滤器的执行顺序。当请求在一个阶段的时候存在多个多个过滤器时，需要根据该方法的返回值依次执行
**shouldFilter**()判断过滤器是否生效

#### 28	如何实现动态Zuul网关路由转发？

传统方式将路由规则配置在配置文件中，如果路由规则发生了改变，需要重启服务器。 

这时候我们结合上节课内容整合Spring Cloud Config分布式配置中心，实现动态路由规则。



#### 29	Zull网关如何搭建集群?

1. Nginx+Zull一主一备或者轮训多个
2. 在微服务中，所有请求统一请求到网关 

#### 30	如何设计一套API接口

接口权限（开放性问题 开放平台 OAuth2.0协议 开放接口|内部接口），

幂等性问题，

安全性问题（Https），

防止篡改数据(验证签名)，

使用网关拦截接口实现黑名单和白名单，

接口使用http协议+json格式restful风格，目的为了跨平台，

考虑高并发，对接口实现保护，服务降级熔断隔离，

最后使用统一的的API接口平台swagger。

#### 31	Spring Cloud和Dubbo区别

**相同点**：Spring Cloud 和Dubbo可以实现RPC远程调用框架，可以实现服务治理。
**不同点**:
Spring Cloud是一套目前比较网站微服务框架了，整合了分布式常用解决方案遇到了问题注册中心Eureka、负载均衡器Ribbon ，客户端调用工具Rest和Feign，分布式配置中心Config，服务保护Hystrix，网关Zuul Gateway ，服务链路Zipkin，消息总线Bus等。 

1）从架构上分析

Dubbo内部实现功能没有SpringCloud强大，只是实现服务治理，缺少分布式配置中心、网关、链路、总线等，如果需要用到这些组件，需要整合其他框架。

 2）从更新迭代速度分析

Dubbo目前更新速度没有SpringCloud快，到SpringCloud2.0后SpringCloud会越来完善和稳定。
 3）从开发背景角度分析

 	Dubbo的开发背景是阿里巴巴， 在中国也推出了非常多的优秀的开源框架。

 	但是在SpringCloud的背景是Spring家族，Spring是专注于企业级开源框架开发，在中国，或者在整个世界上Spring框架都应用的非常广泛。所以相对来说SpringCloud的背景比Dubbo更加强大。
最后总结下：如果学习Dubbo的话，学习其他的分布式解决方案需要自己组装，反而如果学习Spring Cloud，它已经把整个常用分布式解决都整合好了。
2018年10月底，阿里巴巴开源 Spring Cloud Alibaba。