package com.victorzhang.cloud.consul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务注册启动类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:11:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulApplication.class).web(true).run(args);
    }
}
