package com.victorzhang.cloud.redlock;

/**
 * 获取锁管理类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @create 2018-07-10 09:27:33
 */
public interface DistributedLock {

    /**
     * 获取锁
     * @param resourceName
     * @param worker
     * @param <T>
     * @return
     * @throws UnableToAcquiredLockException
     * @throws Exception
     */
    <T> T lock(String resourceName, AcquiredLockWorker<T> worker) throws UnableToAcquiredLockException, Exception;

    /**
     * 获取锁，超时
     * @param resourceName
     * @param worker
     * @param lockTime
     * @param <T>
     * @return
     * @throws UnableToAcquiredLockException
     * @throws Exception
     */
    <T> T lock(String resourceName, AcquiredLockWorker<T> worker, int lockTime) throws UnableToAcquiredLockException, Exception;
}
