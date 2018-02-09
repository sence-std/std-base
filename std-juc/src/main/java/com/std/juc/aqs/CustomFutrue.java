/**
 * @FileName: CustomFutrue.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 下午4:08
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     自定义一个futrue实现
 *     等待结果返回，如果等待超时则自行返回
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
public class CustomFutrue {

    private ReentrantLock lock = new ReentrantLock();
    private Condition c = lock.newCondition();
    private volatile String resp;

    public String get(){
        return get(2000);
    }

    public String get(int timeout){
        lock.lock();
        try {
            long s = System.currentTimeMillis();
            c.await(timeout, TimeUnit.MILLISECONDS);
            System.out.println(" wait :"+(System.currentTimeMillis()-s));
            if(isDone()){
                return resp;
            }else{
                return null;
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public boolean isDone(){
        return resp != null;
    }


    public void doReceiveData(String data){
        lock.lock();
        try {
            resp = data;
            c.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        CustomFutrue cf = new CustomFutrue();
        new Thread(()->{
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cf.doReceiveData("sss");
        }).start();
        String s = cf.get(5000);
        System.out.println(s);
    }
}
