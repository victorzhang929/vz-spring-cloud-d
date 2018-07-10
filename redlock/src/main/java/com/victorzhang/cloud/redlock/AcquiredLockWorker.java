package com.victorzhang.cloud.redlock;

/**
 * 获取锁后需要处理的逻辑
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:25:34
 */
public interface AcquiredLockWorker<T> {

    /**
     * 获取锁进行处理
     * @return
     * @throws Exception
     */
    T invokeAfterLockAcquire() throws Exception;
}
