/**
 * @FileName: CyclicBarrierStart.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 下午11:35
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.juc.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p></p>
 *
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author liusq23
 * @since 1.0
 * @version 1.0
 */
public class CyclicBarrierStart {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    class A implements Runnable{
        @Override
        public void run() {
            System.out.println("reach barrier...");
        }
    }

    public void crun() throws BrokenBarrierException, InterruptedException {
        System.out.println(Thread.currentThread().getName()+" await ...");
        cyclicBarrier.await();
        System.out.println("run ...");
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierStart cyclicBarrierStart = new CyclicBarrierStart();
        new Thread(()->{
            try {
                cyclicBarrierStart.crun();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                cyclicBarrierStart.crun();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        synchronized (cyclicBarrierStart){
            cyclicBarrierStart.wait();
        }
    }


}
