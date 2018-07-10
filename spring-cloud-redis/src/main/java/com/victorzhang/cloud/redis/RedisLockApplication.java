package com.victorzhang.cloud.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Redis分布式锁启动类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 11:19:31
 */
@SpringBootApplication
public class RedisLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLockApplication.class, args);
    }

}
