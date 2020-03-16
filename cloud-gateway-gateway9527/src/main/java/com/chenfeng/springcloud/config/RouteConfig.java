package com.chenfeng.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname RouteConfig
 * @Description TODO
 * @Date 2020/3/8 23:36
 * @Created by  wrsChen
 */
@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
            builder.route("path_routr_chen", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return builder.build();
    }
}
