package com.chenfeng.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname NacosController
 * @Description TODO
 * @Date 2020/3/10 23:51
 * @Created by  wrsChen
 */
@RestController
@Slf4j
@RefreshScope
public class NacosController {
    @Value("${config.info}")
    private String config;
    @GetMapping("/config/info")
    public String privoderPort(){
        return config;
    }
}
