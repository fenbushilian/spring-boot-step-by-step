package com.fbsl.springboot.lock.onejvm.reentrantLock;

import com.fbsl.springboot.lock.onejvm.synchronizedcode.SellerServiceSync;
import org.junit.Test;

/**
 * Created by x1c on 2019/5/12.
 */

public class SellerServiceTest {


    @Test
    public void test1() throws  InterruptedException{
        SellerServiceReentrantLock sellerService = new SellerServiceReentrantLock();
        Thread t1 = new Thread(sellerService,"售票窗口1") ;
        Thread t2 = new Thread(sellerService,"售票窗口2") ;
        Thread t3 = new Thread(sellerService,"售票窗口3") ;
        Thread t4 = new Thread(sellerService,"售票窗口4") ;
        Thread t5 = new Thread(sellerService,"售票窗口5") ;

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


       Thread.sleep(Integer.MAX_VALUE);
    }
}
