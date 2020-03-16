package com.chengfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname AlibabaNacos
 * @Description TODO
 * @Date 2020/3/10 23:42
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacos {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacos.class, args);
    }
}
