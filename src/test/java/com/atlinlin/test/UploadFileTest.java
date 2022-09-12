package com.atlinlin.test;

import org.junit.jupiter.api.Test;

/**
 * @ author : LiLin
 * @ create : 2022-08-16 1:13
 */
public class UploadFileTest {
    @Test
    public void test1(){
        String fileName = "123465.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);

    }
}
