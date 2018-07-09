package com.victorzhang.cloud.feign.controller;

import com.victorzhang.cloud.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign控制器
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 16:09:45
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/{name}")
    public String getClientInformation(@PathVariable("name") String name) {
        return feignService.getClientInformation(name);
    }
}
