package com.atlinlin.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @ author : LiLin
 * @ create : 2022-08-13 1:35
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement //开启事务支持
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class,args);
        log.info("项目启动成功...");
    }
}
