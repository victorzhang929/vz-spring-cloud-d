package com.victorzhang.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端控制器
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 19:27:38
 */
@RestController
public class ClientController {

    @Value("${foo}")
    private  String foo;

    @RequestMapping("/client")
    public String getClientInformation() {
        return foo;
    }
}
