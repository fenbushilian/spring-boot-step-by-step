package com.fbsl.springboot.lock.onejvm.problem;

/**
 * Created by x1c on 2019/5/12.
 */

public class SellerService implements  Runnable {

    int sum = 200 ;

    @Override
    public void run() {
        while(sum >0) {
            System.out.println(Thread.currentThread().getName()+"现在卖了第"+ (sum--)+"张票");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
