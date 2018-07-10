package com.victorzhang.cloud.redis;

/**
 * 全局锁
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 10:49:27
 */
public class Lock {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
