package com.chenfeng.springcloud.dao;

import com.chenfeng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentDao
 * @Description TODO 推荐使用mapper
 * @Date 2020/3/5 23:11
 * @Created by  wrsChen
 */
@Mapper
public interface PaymentDao {
    public int create(Payment paymentDao);
    public Payment getPaymetById(@Param("id") Long id);
}
