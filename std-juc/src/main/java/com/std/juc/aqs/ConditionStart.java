/**
 * @FileName: ConditionStart.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 上午10:19
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.juc.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     学习ReentrantLock Condition
 *     实现多线程顺序打印 A B C
 *     ThreadA   打印  A
 *     ThreadB   打印  B
 *     ThreadC   打印  C
 *     这种方案会导致线程signal了一个没有到达await点的线程，例如：
 *     ThreadA 在signal ThreadB 继续 signal ThreadC后
 *     ThreadA 还未到达await点，这个时候ThreadC signal了 会导致 ThreadA 永远等待，线程卡死
 *  A signal
 *  C将到达await点...
 *  A将到达await点...
 * </p>
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
public class ConditionStart {

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printA(){
        while(true){
            lock.lock();
            try {
                System.out.println("A将到达await点...");
                c1.await();
                System.out.println("A");
                c2.signal();
                System.out.println("B signal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printB(){
        while(true){
            lock.lock();
            try {
                System.out.println("B将到达await点...");
                c2.await();
                System.out.println("B");
                c3.signal();
                System.out.println("C signal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC(){
        while(true){
            lock.lock();
            try {
                System.out.println("C将到达await点...");
                c3.await();
                System.out.println("C");
                c1.signal();
                System.out.println("A signal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void doSignalA(){
        lock.lock();
        try {
            c1.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionStart cs = new ConditionStart();
        new Thread(()->cs.printA()).start();
        new Thread(()->cs.printB()).start();
        new Thread(()->cs.printC()).start();
        cs.doSignalA();
        synchronized (cs) {
            cs.wait();
        }
    }

}
