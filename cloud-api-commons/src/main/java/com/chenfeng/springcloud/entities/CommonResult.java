package com.chenfeng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname CommonResult
 * @Description TODO
 * @Date 2020/3/5 23:08
 * @Created by  wrsChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T Date;
    public CommonResult(Integer code, String message){
    this(code, message, null);
    }
}
