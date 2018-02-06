/**
 * @FileName: Demo.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/6 下午9:14
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     多线程打印：
 *     线程1 打印A
 *     线程2 打印B
 *     线程3 打印C
 *     ABCABCABC...
 *
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
public class Demo {

    private ReentrantLock lock  = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printA() throws InterruptedException {
        while(true) {
            lock.lock();
            try {
                System.out.println("getlock A..");
                c1.await();
                System.out.println("A");
                c2.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printB() throws InterruptedException {
        while(true) {
            lock.lock();
            System.out.println("getlock B..");
            try {
                c2.await();
                System.out.println("B");
                c3.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC() throws InterruptedException {
        while (true) {
            lock.lock();
            System.out.println("getlock C..");
            try {
                c3.await();
                System.out.println("C");
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void signA(){
        lock.lock();
        c1.signal();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo d = new Demo();
        new Thread(()->{
            try {
                d.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                d.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                d.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        d.signA();
        Thread.sleep(10000L);
    }
}
