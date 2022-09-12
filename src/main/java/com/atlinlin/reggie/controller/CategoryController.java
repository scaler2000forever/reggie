package com.atlinlin.reggie.controller;

import com.atlinlin.reggie.common.R;
import com.atlinlin.reggie.entity.Category;
import com.atlinlin.reggie.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ author : LiLin
 * @ create : 2022-08-15 0:46
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;



    /**
     * 新增分类
     * @param category
     * @return
     * 返回值是一个code值根据html中的回调得出
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     * 这里相当于写一句SQL语句查询数据库
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize){
        //分页构造器
        Page<Category> pageInfo = new Page<>(page,pageSize);
        //构造条件构造器 排序问题 entity里有这个属性
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);
        //3.Service调用Mapper操作数据库，查询分页数据 执行查询
        categoryService.page(pageInfo,queryWrapper);
        //4.Controller将查询到的分页数据响应给页面 返回查询结果
        return R.success(pageInfo);
    }

    /**
     * 根据id来删除我们的分类
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long id){
        log.info("删除分类，id为{}",id);
   //     categoryService.removeById(id); //框架实现好基本的操作
        categoryService.remove(id);
        return R.success("分类信息删除成功");
    }

    /**
     * 根据id修改分类信息
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info("修改分类信息：{}",category);
        categoryService.updateById(category);
        return R.success("修改分类信息成功");
    }

    /**
     * 根据条件来查询分类数据
     * 这里相当于写一句SQL语句查询数据库
     * @param category 参数不在请求体中所以，不同于post请求
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType() != null , Category::getType,category.getType());
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }
}
