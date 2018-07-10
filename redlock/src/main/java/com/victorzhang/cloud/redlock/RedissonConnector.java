package com.victorzhang.cloud.redlock;

import javax.annotation.PostConstruct;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

/**
 * 获取Redisson连接类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:33:30
 */
@Component
public class RedissonConnector {

    private RedissonClient redisson;

    @PostConstruct
    public void init() {
        redisson = Redisson.create();
    }

    public RedissonClient getClient() {
        return redisson;
    }
}
