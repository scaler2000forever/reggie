package com.atlinlin.reggie.service.impl;

import com.atlinlin.reggie.entity.User;
import com.atlinlin.reggie.mapper.UserMapper;
import com.atlinlin.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ author : LiLin
 * @ create : 2022-08-17 17:27
 */
@Service
public class UserServicelmpl extends ServiceImpl<UserMapper, User> implements UserService {
}
