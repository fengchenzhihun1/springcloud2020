package cloud.controller;

import cloud.myHandle.MyHandleException;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.chenfeng.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderZKController
 * @Description TODO
 * @Date 2020/3/7 15:34
 * @Created by  wrsChen
 */
@RestController
public class OrderSentinelController {
    public static final String INVOKE_URL = "http://cloudalibaba-sentinel-service";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/info")
    public String paymentInfo(){
       String rresult = restTemplate.getForObject(INVOKE_URL + "/info", String.class);
       return rresult;
    }
    @GetMapping(value = "/payment/{id}")
    @SentinelResource(value = "fallback",fallback = "handleForback", fallbackClass = MyHandleException.class)
    public CommonResult commonResult(@PathVariable("id") Long id) {
        if (id >4) {
            throw new IllegalArgumentException("212");
        } else {
            return this.restTemplate.getForObject(INVOKE_URL + "/payment/" + id, CommonResult.class);
        }
        }




}
