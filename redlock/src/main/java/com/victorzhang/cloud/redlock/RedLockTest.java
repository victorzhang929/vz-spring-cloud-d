package com.victorzhang.cloud.redlock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 分布式锁测试类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 09:39:38
 */
public class RedLockTest {

    public static void main(String[] args) throws Exception {
        new RedLockTest().testRedLock();
    }

    @Autowired
    private RedisLocker distributedLocker;

    public String testRedLock() throws Exception {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        startSignal.countDown();
        doneSignal.await();
        System.out.println("all processors done, shutdown connection");
        return "redLock";
    }

    class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                distributedLocker.lock("test", () -> {
                    doTask();
                    return null;
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void doTask() {
            System.out.println(Thread.currentThread().getName() + " start");
            Random random = new Random();
            int number = random.nextInt(200);
            System.out.println(Thread.currentThread().getName() + " sleep " + number + "millis");
            try {
                Thread.sleep(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
            doneSignal.countDown();
        }
    }
}


