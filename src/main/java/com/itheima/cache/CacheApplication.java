package com.itheima.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * EnableCaching开启缓存注解
 */
@SpringBootApplication
@MapperScan("com.itheima.cache.mapper")
public class CacheApplication {

    /**
     * 启动类main入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
