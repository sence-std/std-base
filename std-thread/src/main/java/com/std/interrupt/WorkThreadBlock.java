/**
 * @FileName:WorkThreadBlock
 * @Package: com.std.thread
 *
 * @author sence
 * @created 3/19/2015 10:18 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.interrupt;

/**
 *
 * <p>
 *  学习线程在block状态时候中断对线程会有什么影响
 *	结果，线程中断继续执行完run方法 详细见WorkThread 头注释
 * </p>
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
public class WorkThreadBlock implements Runnable {
	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 *
	 * @see     Thread#run()
	 */
	@Override
	public void run () {
		System.out.println("Thread start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//线程醒来之后继续执行
		System.out.println("Thread end...");
	}


	public void notifyThis(){
		this.notify();
	}
}
