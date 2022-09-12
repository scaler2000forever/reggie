package com.atlinlin.reggie.service.impl;

import com.atlinlin.reggie.entity.OrderDetail;
import com.atlinlin.reggie.mapper.OrderDetailMapper;
import com.atlinlin.reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ author : LiLin
 * @ create : 2022-08-18 1:51
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
