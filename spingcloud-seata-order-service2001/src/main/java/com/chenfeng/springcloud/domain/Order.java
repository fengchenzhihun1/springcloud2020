package com.chenfeng.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2020/3/16 22:04
 * @Created by  wrsChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private  Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
}
