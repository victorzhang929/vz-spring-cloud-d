package com.victorzhang.cloud.zipkin.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务追踪控制器
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 20:13:13
 */
@RestController
public class ZipkinClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/home")
    public String home() {
        return "i am vz";
    }
}
