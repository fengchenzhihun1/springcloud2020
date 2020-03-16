package chenfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Sentinel8401
 * @Description TODO
 * @Date 2020/3/14 9:50
 * @Created by  wrsChen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401 {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class, args);
    }
}
