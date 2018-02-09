/**
 * @FileName: RateLimiter.java
 * @Package: com.std.thread
 * @author liusq23
 * @created 2018/2/8 上午10:48
 * <p>
 * Copyright 2015 ziroom
 */
package com.std.juc.aqs;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *     限流，每秒只限制5个
 *     但是不能限制任意时刻往下一秒的次数限流，只能限制每秒内的个数
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
public class RateLimiter {

    public volatile LinkedHashMap<Integer,AtomicInteger> map = new LinkedHashMap<>();

    public boolean limit(){
        long _second = Instant.now().getEpochSecond();
        Integer second = new Integer((int)_second);
        while (true) {
            AtomicInteger ai = map.get(second); //放在里面
            if(ai!=null) {
                int num = ai.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"_"+second +"_"+num);
                if (num > 5) {
                    return false;
                } else {
                    return true;
                }
            }else{
                synchronized (this){
                    if(map.get(second)==null){
                        ai = new AtomicInteger(1);
                        System.out.println(Thread.currentThread().getName()+"_"+second +"_"+1);
                        map.put(second,ai);
                        return true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter r = new RateLimiter();
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(r.limit());
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(r.limit());
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(r.limit());
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(r.limit());
            }
        }).start();

        Thread.sleep(5000L);
    }

}
