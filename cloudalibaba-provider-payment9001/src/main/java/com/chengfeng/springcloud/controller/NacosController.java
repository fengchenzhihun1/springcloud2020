package com.chengfeng.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class NacosController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/myport")
    public String privoderPort(){
        return serverPort;
    }
}
