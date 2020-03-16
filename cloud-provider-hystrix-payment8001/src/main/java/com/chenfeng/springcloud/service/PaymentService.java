package com.chenfeng.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/3/8 11:14
 * @Created by  wrsChen
 */
@Service
public class PaymentService {
    public String payment_ok(Integer id){
        return "线程池" + Thread.currentThread().getName()  + "paymentId OK" +id + "\t" + "成功了";
     }



     @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandle", commandProperties = {
             @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
     })
     public String payment_Timeout(Integer id){
        try {
             TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
         }
          return "线程池" + Thread.currentThread().getName()  + "paymentId timneout" +id + "\t" + "aaa";

    }
    public String paymentinfo_TimeoutHandle(Integer id){
        return "线程池" + Thread.currentThread().getName()  + "paymentId timneout" +id + "\t" + "可能是超时出错了";
    }

}
