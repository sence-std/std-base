/**
 * @FileName: RateLimiter2.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 下午10:00
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.juc.aqs;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 限流，相对RateLimiter改善了
 * 限制任意时刻往下一秒的次数限流
 * 大体思想：没调用一次往delay队列插入一个数据（1秒后可以出队列），队列长度只有5个，
 * 1、当offer数据返回flase 则表示队列满了，返回false
 * 当offer数据返回true 则表示放入到了队列，返回true
 * 2、有一个线程不断的从队列take数据
 * </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author liusq23
 * @version 1.0
 * @since 1.0
 */
public class RateLimiter2 {

    class DelayElement implements Delayed {

        private long time;

        private DelayElement(long s) {
            this.time = s;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this) {
                return 0;
            }
            if (o instanceof DelayElement) {
                DelayElement x = (DelayElement) o;
                long diff = time - x.time;
                if (diff < 0) {
                    return -1;
                } else if (diff > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            long d = (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
            return (d == 0) ? 0 : ((d < 0) ? 1 : -1);
        }
    }

    private DelayQueue<DelayElement> delayQueue = new DelayQueue<>();

    public RateLimiter2() {
        initTakeSchedule();
    }

    class TakeThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("start take");
                    DelayElement d = delayQueue.take();
                    System.out.println("take :"+d.time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initTakeSchedule() {
        new Thread(new TakeThread()).start();
    }

    public boolean limit() {
        long millsSecond = System.currentTimeMillis();
        synchronized (delayQueue) {
            System.out.println(Thread.currentThread().getName()+"-"+delayQueue.size());
            if (delayQueue.size() >=5) {
                return false;
            }
            delayQueue.offer(new DelayElement(millsSecond+1000L));
            System.out.println(Thread.currentThread().getName()+" offer "+millsSecond);
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter2 r = new RateLimiter2();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(r.limit());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(r.limit());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(r.limit());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                System.out.println(r.limit());
            }
        }).start();

        Thread.sleep(5000L);
    }

}
