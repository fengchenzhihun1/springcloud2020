package com.chenfeng.springcloud.dao;

import com.chenfeng.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname OrderDao
 * @Description TODO
 * @Date 2020/3/16 21:59
 * @Created by  wrsChen
 */
@Mapper
public interface OrderDao {
    // 新建订单
    public void create(Order order);
    public void update(@Param("userId") Long userId, @Param("status") Integer status);


}
