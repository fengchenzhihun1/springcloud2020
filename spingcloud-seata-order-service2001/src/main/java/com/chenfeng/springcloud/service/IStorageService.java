package com.chenfeng.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname IStorageService
 * @Description TODO
 * @Date 2020/3/16 22:09
 * @Created by  wrsChen
 */
@FeignClient(name = "seata-storage-service")
public interface IStorageService {
        @PostMapping("/seata-storage-service/decreaseStorage")
        void decreaseStorage(@RequestParam("productId") Long productId,
                             @RequestParam("count")Integer count);
}
