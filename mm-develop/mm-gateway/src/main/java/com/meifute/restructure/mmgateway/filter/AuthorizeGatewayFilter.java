//package com.meifute.restructure.mmgateway.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.PathContainer;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @auther liuliang
// * @date 2020/4/7 10:54 AM
// */
//@Component
//public class AuthorizeGatewayFilter implements GlobalFilter, Ordered {
//
//    private static final String AUTHORIZE_TOKEN = "Authorization";
//
//    private static final String AUTHORIZE_UID = "uid";
//
//    public static final String AUTH = "auth:" ;
//
//    public static final String BEARER = "Bearer ";
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        HttpHeaders headers = request.getHeaders();
//        String token = headers.getFirst(AUTHORIZE_TOKEN);
//
//        if (token == null) {
//            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
//        }
//        String path = request.getPath().value();
//
//        if(path.contains("/mm-auth")){
//            return chain.filter(exchange);
//        }
//        ServerHttpResponse response = exchange.getResponse();
//        if (StringUtils.isEmpty(token)) {
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//        String authToken = stringRedisTemplate.opsForValue().get(AUTH+token.replaceAll(BEARER,"").trim());
//        if (authToken == null) {
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//
//}