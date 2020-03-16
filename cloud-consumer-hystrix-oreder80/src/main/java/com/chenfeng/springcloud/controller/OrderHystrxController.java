package com.chenfeng.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.chenfeng.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Classname OrderFeignController
 * @Description TODO
 * @Date 2020/3/8 9:55
 * @Created by  wrsChen
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrxController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/consum/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentService.payment_ok(id);
        return result;
    }
//    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandle", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })
    @HystrixCommand
    @GetMapping("/consum/hystrix/timeout/{id}")
    public String payment_Timeout(@PathVariable("id") Integer id){
       int age = 10/0;
        String result = paymentService.payment_Timeout(id);
        return result;
    }

    public String paymentinfo_TimeoutHandle(Integer id){
        return "线程池" + Thread.currentThread().getName()  + "paymentId timneout" +id + "\t" + "可能是超时出错了";
    }
    public String payment_Global_fallbackMethod(){
        return "全局异常处理信息";
    }
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 请求窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到所述后跳闸
    })

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
