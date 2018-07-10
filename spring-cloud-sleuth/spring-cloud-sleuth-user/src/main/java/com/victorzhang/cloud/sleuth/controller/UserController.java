package com.victorzhang.cloud.sleuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 16:31:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/home")
    public String home() {
        return "I'm vz";
    }
}
