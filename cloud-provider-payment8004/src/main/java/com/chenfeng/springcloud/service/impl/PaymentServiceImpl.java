package com.chenfeng.springcloud.service.impl;


import com.chenfeng.springcloud.dao.PaymentDao;
import com.chenfeng.springcloud.entities.Payment;
import com.chenfeng.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Description TODO
 * @Date 2020/3/5 23:30
 * @Created by  wrsChen
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment){
     return  paymentDao.create(payment);
    }
    @Override
    public Payment getPaymetById(@Param("id") Long id){
     return paymentDao.getPaymetById(id);
    }
}
