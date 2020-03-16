package com.chenfeng.springcloud.service;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/3/8 9:48
 * @Created by  wrsChen
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_Timeout(@PathVariable("id") Integer id);

}
