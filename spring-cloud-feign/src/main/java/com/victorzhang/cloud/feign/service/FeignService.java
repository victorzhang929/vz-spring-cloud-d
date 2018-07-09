package com.victorzhang.cloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign业务逻辑
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 16:07:16
 */
@FeignClient(value = "eureka-client", fallback = FeignServiceError.class)
public interface FeignService {

    @GetMapping("/user/{name}")
    String getClientInformation(@PathVariable("name") String name);
}
