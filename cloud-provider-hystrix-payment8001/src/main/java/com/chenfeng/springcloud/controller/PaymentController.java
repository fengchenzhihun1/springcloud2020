package com.chenfeng.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.chenfeng.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/3/8 11:20
 * @Created by  wrsChen
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port} ")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentService.payment_ok(id);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_Timeout(@PathVariable("id") Integer id){
        String result = paymentService.payment_Timeout(id);
        return result;
    }
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 请求窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到所述后跳闸
    })
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return Thread.currentThread().getName() + "调用成功，成功流水" + IdUtil.simpleUUID();
    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return  "请稍后再试" + id;
    }

}
