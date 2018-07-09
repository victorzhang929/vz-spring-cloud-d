package com.victorzhang.cloud.feign.service;

import org.springframework.stereotype.Component;

/**
 * FeignService熔断
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-09 16:50:23
 */
@Component
public class FeignServiceError implements FeignService {
    @Override
    public String getClientInformation(String name) {
        return "sorry, " + name;
    }
}
