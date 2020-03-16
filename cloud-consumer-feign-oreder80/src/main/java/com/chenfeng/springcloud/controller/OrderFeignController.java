package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import com.chenfeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderFeignController
 * @Description TODO
 * @Date 2020/3/8 9:55
 * @Created by  wrsChen
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentService paymentService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymetById(id);
    }
}
