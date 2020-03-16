package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname Stream8801
 * @Description TODO
 * @Date 2020/3/9 23:09
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableEurekaClient
public class Stream8801 {
    public static void main(String[] args) {
        SpringApplication.run(Stream8801.class, args);
    }
}
