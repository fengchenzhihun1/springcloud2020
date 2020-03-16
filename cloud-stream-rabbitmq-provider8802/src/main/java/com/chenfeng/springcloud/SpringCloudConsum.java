package com.chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname SpringCloudConsum
 * @Description TODO
 * @Date 2020/3/9 23:39
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConsum {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsum.class, args);
    }
}
