package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Order80
 * @Description TODO
 * @Date 2020/3/7 15:15
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderSentinel84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderSentinel84.class, args);
    }
}
