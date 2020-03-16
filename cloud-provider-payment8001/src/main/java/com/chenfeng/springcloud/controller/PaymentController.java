package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import com.chenfeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/3/5 23:34
 * @Created by  wrsChen
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,端口：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id){
        Payment result = paymentService.getPaymetById(id);
        if (result != null) {
            return new CommonResult(200, "查询数据成功端口：" + serverPort, result);
        } else {
            return new CommonResult(444, "查询数据失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
       List<String> services = discoveryClient.getServices();
       for (String element : services) {
        log.info(element);
       }
      List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstances ) {
            log.info(serviceInstance.getServiceId() + "\t" +serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getpaymentLB(){
        return serverPort;
    }

}
