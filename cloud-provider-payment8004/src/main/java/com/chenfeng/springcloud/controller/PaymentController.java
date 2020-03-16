package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import com.chenfeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/3/5 23:34
 * @Created by  wrsChen
 */
@RestController

public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功端口"+serverPort, result);
        } else {
            return new CommonResult(444, "插入失败",null);
        }
    }
    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id){
        Payment result = paymentService.getPaymetById(id);
        if (result != null) {
            return new CommonResult(200, "查询数据成功端口" + serverPort, result);
        } else {
            return new CommonResult(444, "查询数据失败",null);
        }
    }
    @GetMapping("/info")
    public String getResult() {
        return "成功了";
    }
}
