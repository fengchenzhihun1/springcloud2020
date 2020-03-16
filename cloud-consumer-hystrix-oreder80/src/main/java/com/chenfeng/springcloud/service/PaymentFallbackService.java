package com.chenfeng.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/3/8 20:37
 * @Created by  wrsChen
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public String payment_ok(Integer id) {
        return "fallbhack";
    }

    @Override
    public String payment_Timeout(Integer id) {
        return "fallback";
    }



}
