package com.chenfeng.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyselefRule
 * @Description TODO
 * @Date 2020/3/7 23:37
 * @Created by  wrsChen
 */@Configuration
public class MyselefRule {
     @Bean
     public IRule myRule(){
         return new RandomRule(); // 随机
     }
}
