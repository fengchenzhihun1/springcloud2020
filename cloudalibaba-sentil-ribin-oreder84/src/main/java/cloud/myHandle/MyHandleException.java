package cloud.myHandle;

import com.chenfeng.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname MyHandleException
 * @Description TODO
 * @Date 2020/3/15 21:29
 * @Created by  wrsChen
 */
public class MyHandleException {
    public CommonResult handleForback(@PathVariable("id") Long id, Throwable e){

        return  new CommonResult(444,"wqwq", e.getMessage());
    }
}
