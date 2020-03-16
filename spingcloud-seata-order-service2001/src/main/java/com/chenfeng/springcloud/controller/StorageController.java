package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.domain.CommonResult;
import com.chenfeng.springcloud.domain.Order;
import com.chenfeng.springcloud.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/3/16 22:07
 * @Created by  wrsChen
 */
@RestController
public class StorageController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/createOrder")
    public CommonResult createOrder(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功!");
    }
}
