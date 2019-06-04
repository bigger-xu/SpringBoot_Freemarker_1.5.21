package com.cto.explosive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Zhang Yongwei
 */
@SpringBootApplication
@MapperScan("com.cto.explosive.dao")
/**
 * 事务配置
 * @author Zhang Yongwei
 */
@EnableTransactionManagement
public class ExplosiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExplosiveApplication.class, args);
    }

}
