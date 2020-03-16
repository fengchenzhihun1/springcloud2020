package com.chenfeng.springcloud.service;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/3/8 9:48
 * @Created by  wrsChen
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymetById(@PathVariable("id") Long id);
}
