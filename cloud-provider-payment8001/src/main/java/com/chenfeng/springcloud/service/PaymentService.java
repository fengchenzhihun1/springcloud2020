package com.chenfeng.springcloud.service;

import com.chenfeng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/3/5 23:28
 * @Created by  wrsChen
 */
public interface PaymentService {
    public int create(Payment paymentDao);
    public Payment getPaymetById(@Param("id") Long id);
}
