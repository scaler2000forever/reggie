package com.atlinlin.reggie.service;

import com.atlinlin.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ author : LiLin
 * @ create : 2022-08-15 0:42
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
