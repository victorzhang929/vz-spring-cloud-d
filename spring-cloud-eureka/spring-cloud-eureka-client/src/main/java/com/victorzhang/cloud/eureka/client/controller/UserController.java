package com.victorzhang.cloud.eureka.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 14:55:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/{name}")
    @HystrixCommand(fallbackMethod = "homeError")
    public String home(@PathVariable("name") String name) {
        return "hi " + name + ",i am form port:" + port;
    }

    public String homeError(String name) {
        return "hi " + name + ",i am sorry!";
    }
}
