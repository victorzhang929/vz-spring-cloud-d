package com.victorzhang.cloud.eureka.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon业务逻辑
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 15:39:48
 */
@Service
public class RibbonServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ribbonServiceError")
    public String ribbonService(String name) {
        return restTemplate.getForObject("http://eureka-client/user/" + name, String.class);
    }

    public String ribbonServiceError(String name) {
        return "hi " + name + ", sorry, error";
    }
}
