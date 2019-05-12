package com.fbsl.springboot.lock.onejvm.synchronizedcode;

/**
 * Created by x1c on 2019/5/12.
 */

public class SellerServiceSync implements Runnable {

    int sum = 200;

    @Override
    public void run() {
        synchronized (this) {
            while (sum > 0) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "现在卖了第" + (sum--) + "张票");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
