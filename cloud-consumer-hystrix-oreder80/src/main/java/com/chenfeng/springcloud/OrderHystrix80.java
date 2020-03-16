package com.chenfeng.springcloud;/**
 * @Classname OrderHystrix80
 * @Description TODO
 * @Date 2020/3/8 11:57
 * @Created by  wrsChen
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class OrderHystrix80  {

    public static void main(String[] args) {

        SpringApplication.run(OrderHystrix80.class, args);
    }


}
