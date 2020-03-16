package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import com.chenfeng.springcloud.lb.LoadBlance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/3/6 0:33
 * @Created by  wrsChen
 */
@RestController
public class OrderController {
    //public static final String Pay_url = "http://localhost:8001";
    public static final String Pay_url = "http://CLOUD-PAYMENT-SERVICE/";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBlance loadBlance;
    @Resource
    DiscoveryClient discoveryClient;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return  restTemplate.postForObject(Pay_url + "payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(Pay_url + "payment/get/" + id, CommonResult.class);
    }
    @GetMapping("/consumer/consule/payment/get/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
       ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(Pay_url + "payment/get/" +id, CommonResult.class);
       if( responseEntity.getStatusCode().is2xxSuccessful()){
           return responseEntity.getBody();
       } else {
           return new CommonResult<>(444, "操作失败");
       }
    }
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBlance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "payment/lb", String.class);

    }

}
