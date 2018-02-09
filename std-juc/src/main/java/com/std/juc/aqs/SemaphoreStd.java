/**
 * @FileName: RateLimiter2.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 下午4:30
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.juc.aqs;

import java.util.concurrent.Semaphore;

/**
 * <p>
 *   信号量可限制
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
public class SemaphoreStd {

    private Semaphore semaphore = new Semaphore(1);

    public void dosth() throws InterruptedException {
        semaphore.acquire(1);
        try {
            Thread.sleep(10L);
            System.out.println(System.currentTimeMillis());
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreStd ra = new SemaphoreStd();
        for(int i=0;i<1000;i++){
            ra.dosth();
        }
    }
}
