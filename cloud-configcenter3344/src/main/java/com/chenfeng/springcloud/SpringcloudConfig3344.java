package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname SpringcloudConfig3344
 * @Description TODO
 * @Date 2020/3/9 0:57
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringcloudConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfig3344.class, args);
    }
}
