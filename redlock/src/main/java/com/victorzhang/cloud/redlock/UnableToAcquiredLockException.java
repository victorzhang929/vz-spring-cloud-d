package com.victorzhang.cloud.redlock;

/**
 * 无法获取锁异常类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:29:50
 */
public class UnableToAcquiredLockException extends RuntimeException {

    public UnableToAcquiredLockException() {}

    public UnableToAcquiredLockException(String message) {
        super(message);
    }

    public UnableToAcquiredLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
