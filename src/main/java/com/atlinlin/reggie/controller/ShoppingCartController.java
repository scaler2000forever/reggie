package com.atlinlin.reggie.controller;

import com.atlinlin.reggie.common.BaseContext;
import com.atlinlin.reggie.common.R;
import com.atlinlin.reggie.entity.ShoppingCart;
import com.atlinlin.reggie.service.ShoppingcartService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ author : LiLin
 * @ create : 2022-08-17 23:15
 */
@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class ShoppingCartController {
    @Autowired
    private ShoppingcartService shoppingcartService;

    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart) {
        log.info("购物车数据：{}", shoppingCart);
        //设置用户id，指定当前是哪个用户的购物车数据
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);

        //查询当前菜品或者套餐是否已经在购物车当中
        Long dishId = shoppingCart.getDishId();

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, currentId);

        if (dishId != null) {
            //添加到购物车的为菜品
            queryWrapper.eq(ShoppingCart::getDishId, dishId);
        } else {
            //添加到购物车的为套餐
            queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        }
        //SQL:select *from shopping_cart where user_id=? and dish_id/setmeal_id =?
        ShoppingCart cartServiceone = shoppingcartService.getOne(queryWrapper);

        if(cartServiceone!=null) {
            //如果已经存在，则在原来的基础上加一
            Integer number = cartServiceone.getNumber();
            cartServiceone.setNumber(number+1);
            shoppingcartService.updateById(cartServiceone);
        }else {
            //如果不存在，则添加到购物车中，默认为一
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingcartService.save(shoppingCart);
            cartServiceone=shoppingCart;
        }
        return R.success(cartServiceone);
    }

    /**
     * 展示购物车数据
     * @return
     */
    @GetMapping("/list")
    public R<List<ShoppingCart>> list(){
        log.info("查看购物车");
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);
        List<ShoppingCart> list = shoppingcartService.list(queryWrapper);
        return R.success(list);
    }

    /**
     * 清空购物车
     * @return
     */
    @DeleteMapping("/clean")
    public R<String> clean(){
        //SQl: delete from shopping_cart where user_id = ?

        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());

        shoppingcartService.remove(queryWrapper);

        return R.success("清空购物车成功");
    }


}
