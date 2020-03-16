package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname OpenfeignOreder80
 * @Description TODO
 * @Date 2020/3/8 9:46
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenfeignOreder80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOreder80.class, args);
    }
}
