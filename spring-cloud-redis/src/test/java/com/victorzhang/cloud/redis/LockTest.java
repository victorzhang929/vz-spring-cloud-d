package com.victorzhang.cloud.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Redis分布式锁测试类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 11:16:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LockTest {

    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @Test
    public void testRedisLock() {
        Lock lock = new Lock("username", "vz");
        if (distributedLockHandler.tryLock(lock)) {
            System.out.println("acquire lock");
            distributedLockHandler.releaseLock(lock);
        } else {
            System.out.println("can not acquire lock");
        }
    }
}
