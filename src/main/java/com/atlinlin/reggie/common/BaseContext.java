package com.atlinlin.reggie.common;

/**
 * @ author : LiLin
 * @ create : 2022-08-14 22:22
 */

/**
 * 基于ThreadLocal封装的工具类，用户保存和获取当前登录用户id
 * 以线程为作用域，每个都有自己的副本
 */

public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    //工具方法，设置为静态的
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
