package com.chenfeng.springcloud.controller;

import com.chenfeng.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SendMessageController
 * @Description TODO
 * @Date 2020/3/9 23:18
 * @Created by  wrsChen
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;
    @GetMapping("/getInfo")
    public String send(){
        return  iMessageProvider.send();
    }
}
