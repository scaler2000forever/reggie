package com.atlinlin.reggie.service.impl;

import com.atlinlin.reggie.entity.Employee;
import com.atlinlin.reggie.mapper.EmployeeMapper;
import com.atlinlin.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ author : LiLin
 * @ create : 2022-08-13 12:33
 */
//让spring容器去管理
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
