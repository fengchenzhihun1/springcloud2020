package com.chenfeng.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname HystriDashboard9001
 * @Description TODO
 * @Date 2020/3/8 22:20
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystriDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystriDashboard9001.class, args);
    }

}
