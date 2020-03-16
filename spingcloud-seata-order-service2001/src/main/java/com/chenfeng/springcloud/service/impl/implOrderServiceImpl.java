package com.chenfeng.springcloud.service.impl;

import com.chenfeng.springcloud.dao.OrderDao;
import com.chenfeng.springcloud.domain.Order;
import com.chenfeng.springcloud.service.IAccountService;
import com.chenfeng.springcloud.service.IOrderService;
import com.chenfeng.springcloud.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname implOrderServiceImpl
 * @Description TODO
 * @Date 2020/3/16 22:09
 * @Created by  wrsChen
 */
@Slf4j
@Service
public class implOrderServiceImpl implements IOrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private IStorageService storageService;
    @Resource
    private IAccountService accountService;
    @Override
    public void create(Order order) {
        log.info("hiahiaO(∩_∩)O~~ -----创建定单开始--------"+new SimpleDateFormat("yyyy-MM-ddhh:mm:ss").format(new Date()));
        orderDao.create(order);
        log.info("2.定单服务开始做库存扣减 begin hiahiaO(∩_∩)O~~!!");
        storageService.decreaseStorage(order.getProductId(),order.getCount());
        log.info("3.定单服务结束做库存扣减 end hiahiaO(∩_∩)O~~!!");
        log.info("4.定单服务开始扣用户钱 begin hiahiaO(∩_∩)O~~!!");
        accountService.kouqian(order.getUserId(),order.getMoney());
        log.info("5.定单服务结束扣用户钱 end hiahiaO(∩_∩)O~~!!");
        orderDao.update(order.getUserId(),0);
        log.info("hiahiaO(∩_∩)O~~ -----创建定单成功--------"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}

