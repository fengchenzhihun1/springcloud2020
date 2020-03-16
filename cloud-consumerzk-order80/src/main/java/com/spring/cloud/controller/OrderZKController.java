package com.spring.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderZKController
 * @Description TODO
 * @Date 2020/3/7 15:34
 * @Created by  wrsChen
 */
@RestController
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/info")
    public String paymentInfo(){
       String rresult = restTemplate.getForObject(INVOKE_URL + "/info", String.class);
       return rresult;
    }
}
