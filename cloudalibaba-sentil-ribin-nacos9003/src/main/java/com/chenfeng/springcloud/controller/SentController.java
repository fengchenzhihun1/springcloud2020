package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Classname SentController
 * @Description TODO
 * @Date 2020/3/15 20:58
 * @Created by  wrsChen
 */
@RestController
public class SentController {
    @Value("${server.port}")
    String serverport;
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static
    {
        hashMap.put(1L,new  Payment(1L,"qqqd12q1"));
        hashMap.put(2L,new  Payment(2L,"qqqq11"));
        hashMap.put(3L,new  Payment(3L,"qqq1q1"));
    }
    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> paymentsql(@PathVariable("id")Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "duan"+serverport, payment);
        return  result;
    }
}
