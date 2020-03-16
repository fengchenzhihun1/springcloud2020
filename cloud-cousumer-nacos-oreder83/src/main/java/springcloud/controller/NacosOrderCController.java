package springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname NacosController
 * @Description TODO
 * @Date 2020/3/10 23:51
 * @Created by  wrsChen
 */
@RestController
@Slf4j
public class NacosOrderCController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
    @GetMapping("/consumer/myport")
    public String privoderPort(){
        serverPort =  restTemplate.getForObject(serverURL + "/myport", String.class);
        return serverPort;
    }

}
