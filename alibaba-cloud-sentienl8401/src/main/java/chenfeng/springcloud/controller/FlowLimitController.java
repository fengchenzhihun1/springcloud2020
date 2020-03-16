package chenfeng.springcloud.controller;

import chenfeng.springcloud.myhandle.CustomerBlocakHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname FlowLimitController
 * @Description TODO
 * @Date 2020/3/14 9:55
 * @Created by  wrsChen
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB";
    }
    @GetMapping("/testD")
    public String testD() {
        int a = 10/0;
        return "测试异常比例";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_hotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1
    ,@RequestParam(value = "p2" ,required = false) String p2){
        return "hoteKey";
    }
    public String deal_hotKey(String p1, String p2, BlockException ex){
        return "hotkey)_";
    }
    @GetMapping("/rateLimit/customerBlockHandle")
    @SentinelResource(value = "customerBlockHandle", blockHandler = "handleException", blockHandlerClass = CustomerBlocakHandler.class)
    public CommonResult customerBlockHandler() {
        return new CommonResult(200,"客户自定义限流OK",new Payment(2020L,"serial"));
    }



}
