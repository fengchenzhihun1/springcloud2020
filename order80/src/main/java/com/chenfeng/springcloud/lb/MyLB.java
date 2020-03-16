package com.chenfeng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname MyLB
 * @Description TODO
 * @Date 2020/3/8 9:00
 * @Created by  wrsChen
 */
@Component
public class MyLB implements LoadBlance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncremrnt(){
        int current;
        int next;
        do {
          current = this.atomicInteger.get();
          next = current >= 2147483647 ? 0:current +1;
        } while(!this.atomicInteger.compareAndSet(current, next));
        return atomicInteger.get();
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncremrnt() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
