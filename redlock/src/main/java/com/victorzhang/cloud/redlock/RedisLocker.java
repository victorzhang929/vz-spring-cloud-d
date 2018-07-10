package com.victorzhang.cloud.redlock;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Redis锁
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:35:31
 */
@Component
public class RedisLocker implements DistributedLock {

    private static final String LOCK_PREFIX = "lock:";

    @Autowired
    private RedissonConnector redissonConnector;

    @Override
    public <T> T lock(String resourceName, AcquiredLockWorker<T> worker) throws UnableToAcquiredLockException, Exception {
        return lock(resourceName, worker, 100);
    }

    @Override
    public <T> T lock(String resourceName, AcquiredLockWorker<T> worker, int lockTime) throws UnableToAcquiredLockException, Exception {
        RedissonClient redissonClient = redissonConnector.getClient();
        RLock lock = redissonClient.getLock(LOCK_PREFIX + resourceName);

        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if (success) {
            try {
                return worker.invokeAfterLockAcquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToAcquiredLockException();
    }
}
