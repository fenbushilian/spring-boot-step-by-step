package com.fbsl.springboot.lock.onejvm.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by x1c on 2019/5/12.
 */

public class SellerServiceReentrantLock implements Runnable {

    int sum = 200;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (sum > 0) {
            //System.out.println(sum);
            lock.tryLock();
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "现在卖了第" + (sum--) + "张票");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
