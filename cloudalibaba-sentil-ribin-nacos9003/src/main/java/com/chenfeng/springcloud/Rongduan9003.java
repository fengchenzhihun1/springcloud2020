package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Rongduan9003
 * @Description TODO
 * @Date 2020/3/15 20:56
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Rongduan9003 {
    public static void main(String[] args) {
        SpringApplication.run(Rongduan9003.class, args);
    }
}
