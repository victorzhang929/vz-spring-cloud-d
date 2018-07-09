package com.victorzhang.cloud.eureka.ribbon.controller;

import com.victorzhang.cloud.eureka.ribbon.service.RibbonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ribbon控制器
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 15:41:40
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonServiceImpl ribbonService;

    @GetMapping("/client/{name}")
    public String getClientInformation(@PathVariable("name") String name) {
        return ribbonService.ribbonService(name);
    }
}
