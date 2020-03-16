package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname GateWayMain9527
 * @Description TODO
 * @Date 2020/3/8 23:14
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
