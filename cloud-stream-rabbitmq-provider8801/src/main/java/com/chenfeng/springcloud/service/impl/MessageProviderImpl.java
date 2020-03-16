package com.chenfeng.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.chenfeng.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


import javax.annotation.Resource;

/**
 * @Classname MessageProviderImpl
 * @Description TODO
 * @Date 2020/3/9 23:12
 * @Created by  wrsChen
 */
@EnableBinding(Source.class) // 定义信息推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("se" + serial);
        return null;
    }
}
