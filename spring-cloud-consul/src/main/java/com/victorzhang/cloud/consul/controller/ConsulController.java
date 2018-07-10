package com.victorzhang.cloud.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务注册控制器
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:12:54
 */
@RestController
public class ConsulController {

    @GetMapping("/home")
    public String home() {
        return "i am vz";
    }
}
