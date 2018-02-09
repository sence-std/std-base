/**
 * @FileName: ConditionStart2.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 上午10:37
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
public class ConditionStart2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private volatile  boolean flagA = true;
    private volatile  boolean flagB = true;
    private volatile  boolean flagC = true;

    public void printA(){
        while (true){
            lock.lock();
            try {
                while(!flagA){
                    c1.await();
                }
                System.out.println("A");
                flagA = false;
                flagB = true;
                c1.signalAll();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public void printB(){
        while (true){
            lock.lock();
            try {
                while(!flagB){
                    c1.await();
                }
                System.out.println("B");
                flagB = false;
                flagC = true;
                c1.signalAll();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public void printC(){
        while (true){
            lock.lock();
            try {
                while(!flagC){
                    c1.await();
                }
                System.out.println("C");
                flagC = false;
                flagA = true;
                c1.signalAll();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionStart2 conditionStart2 = new ConditionStart2();
        new Thread(()->conditionStart2.printA()).start();
        new Thread(()->conditionStart2.printB()).start();
        new Thread(()->conditionStart2.printC()).start();
        synchronized (conditionStart2){
            conditionStart2.wait();
        }
    }

}
