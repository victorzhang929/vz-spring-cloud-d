package com.victorzhang.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * cloud服务端配置中心启动类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 19:26:14
 */
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
