package com.chenfeng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname Config335
 * @Description TODO
 * @Date 2020/3/9 1:49
 * @Created by  wrsChen
 */
@RefreshScope
@RestController
public class Config3366 {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configinfo")
    public String getConfiInfo(){
        return configInfo;
    }
}
