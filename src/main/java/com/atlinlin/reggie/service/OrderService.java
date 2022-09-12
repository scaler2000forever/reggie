package com.atlinlin.reggie.service;

import com.atlinlin.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ author : LiLin
 * @ create : 2022-08-18 1:48
 */
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    void submit(Orders orders);
}
