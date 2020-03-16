package com.chenfeng.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PaymentControlloer
 * @Description TODO
 * @Date 2020/3/7 19:00
 * @Created by  wrsChen
 */
@RestController
public class PaymentControlloer {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/consul")
    public String payment(){
        return "spring cloud with consul" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
