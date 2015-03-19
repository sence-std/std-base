package com.std.base; /**
 * @FileName:WorkThread
 * @Package: PACKAGE_NAME
 *
 * @author sence
 * @created 3/19/2015 10:02 AM
 *
 * Copyright 2011-2015 Asura
 */

/**
 *
 * <p>中断线程</p>
 *
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author sence
 * @since 1.0
 * @version 1.0
 */
public class WorkThread implements Runnable {

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see     Thread#run()
	 */
	@Override public void run () {
		while(true){
			if(Thread.interrupted()){
				System.out.println("Someone interrupted me.");
			}else{
				System.out.println("Going...");
			}
			long now = System.currentTimeMillis();
			while(System.currentTimeMillis()-now<1000){
				// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
				// 此处用这种方法空转1秒
			}
		}
	}
}
