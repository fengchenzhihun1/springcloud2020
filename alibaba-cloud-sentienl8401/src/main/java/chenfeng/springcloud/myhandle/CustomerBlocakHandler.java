package chenfeng.springcloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chenfeng.springcloud.entities.CommonResult;
import com.chenfeng.springcloud.entities.Payment;

/**
 * @Classname CustomerBlocakHandler
 * @Description TODO
 * @Date 2020/3/15 20:36
 * @Created by  wrsChen
 */
public class CustomerBlocakHandler {
    public static CommonResult handleException(BlockException e) {
        return new CommonResult(444,"客户兹定于", new Payment(2020L,"00032"));
    }
    public static CommonResult handleException2(BlockException e) {
        return new CommonResult(442,"客户兹定于", new Payment(2020L,"00032"));
    }
}
