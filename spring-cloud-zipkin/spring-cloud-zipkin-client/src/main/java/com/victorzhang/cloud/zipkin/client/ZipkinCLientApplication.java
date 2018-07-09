package com.victorzhang.cloud.zipkin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 链路追踪客户端启动类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 20:04:19
 */
@SpringBootApplication
public class ZipkinCLientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinCLientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
}
