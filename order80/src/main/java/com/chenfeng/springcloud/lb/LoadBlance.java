package com.chenfeng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBlance
 * @Description TODO
 * @Date 2020/3/8 8:59
 * @Created by  wrsChen
 */
public interface LoadBlance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
