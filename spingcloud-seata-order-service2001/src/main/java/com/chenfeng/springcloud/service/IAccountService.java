package com.chenfeng.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname IAccountService
 * @Description TODO
 * @Date 2020/3/16 22:08
 * @Created by  wrsChen
 */
@FeignClient(name = "seata-account-service")
public interface IAccountService {
    @PostMapping("/seata-account-service/kouqian")
    void kouqian(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money);

}
