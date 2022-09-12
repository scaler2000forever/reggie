package com.atlinlin.reggie.common;

/**
 * @ author : LiLin
 * @ create : 2022-08-15 17:33
 */

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
