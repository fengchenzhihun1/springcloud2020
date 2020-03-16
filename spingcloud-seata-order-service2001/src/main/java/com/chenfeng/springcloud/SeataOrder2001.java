package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname SeataOrder2001
 * @Description TODO
 * @Date 2020/3/16 21:57
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataOrder2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001.class, args);
    }

}
