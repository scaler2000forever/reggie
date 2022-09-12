package com.atlinlin.reggie.service;

import com.atlinlin.reggie.dto.SetmealDto;
import com.atlinlin.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @ author : LiLin
 * @ create : 2022-08-15 15:25
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids );
}
