package com.victorzhang.cloud.redis;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 分布式锁Handler
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 10:51:59
 */
@Component
public class DistributedLockHandler {

    private static final Logger logger = LoggerFactory.getLogger(DistributedLockHandler.class);

    //单个业务持有锁的时间30s，防止死锁
    private static final long LOCK_EXPIRE = 30 * 1000L;
    //默认30ms尝试一次
    private static final long LOCK_TRY_INTERVAL = 30L;
    //默认尝试20s
    private static final long LOCK_TRY_TIMEOUT = 20 * 1000L;

    @Autowired
    private StringRedisTemplate template;

    /**
     * 尝试获取全局锁
     *
     * @param lock 锁对象
     * @return true获取成功，false获取失败
     */
    public boolean tryLock(Lock lock) {
        return tryLock(lock, LOCK_TRY_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock    锁对象
     * @param timeout 超时
     * @return true获取成功，false获取失败
     */
    public boolean tryLock(Lock lock, long timeout) {
        return tryLock(lock, timeout, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock    锁对象
     * @param timeout 超时
     * @param interval 重试间隔
     * @return true获取成功，false获取失败
     */
    public boolean tryLock(Lock lock, long timeout, long interval) {
        return tryLock(lock, timeout, interval, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock    锁对象
     * @param timeout 超时
     * @param interval 重试间隔
     * @param expire 锁对象失效时间
     * @return true获取成功，false获取失败
     */
    public boolean tryLock(Lock lock, long timeout, long interval, long expire) {
        return getLock(lock, timeout, interval, expire);
    }

    public boolean getLock(Lock lock, long timeout, long interval, long expire) {
        try {
            if (StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            do {
                if (!template.hasKey(lock.getName())) {
                    ValueOperations<String, String> ops = template.opsForValue();
                    ops.set(lock.getName(), lock.getValue(), expire, TimeUnit.MILLISECONDS);
                    return true;
                } else {
                    logger.debug("lock is exist!!");
                }
                //重试
                if (System.currentTimeMillis() - startTime > timeout) {
                    return false;
                }
                Thread.sleep(interval);
            } while (template.hasKey(lock.getName()));
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            return false;
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param lock
     */
    public void releaseLock(Lock lock) {
        if (!StringUtils.isEmpty(lock.getName())) {
            template.delete(lock.getName());
        }
    }
}
