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
 * <p>
 *  学习线程在runable状态时候中断对线程会有什么影响
 *	结果，线程中断只是一个标识，线程依旧往下执行直到结束完run方法
 *
 *  在Core Java中有这样一句话："没有任何语言方面的需求要求一个被中断的程序应该终止。中断一个线程只是为了引起该线程的注意，被中断线程可以决定如何应对中断 "
 *  这说明: interrupt中断的是线程的某一部分业务逻辑，前提是线程需要检查自己的中断状态(isInterrupted())。
 *  //corejava Interrupted的经典使用代码
 *	 public void run(){
 *		 try{
 *			 ....
 *			 while(!Thread.currentThread().isInterrupted()&& more work to do){
 *			 // do more work;
 *		 }
 *	 }catch(InterruptedException e){
 *			 // thread was interrupted during sleep or wait
 *		 }
 *		 finally{
 *			 // cleanup, if required
 *		 }
 *	 }
 *	线程中断是指线程在runable状态时，才会中断， 没有占用CPU运行的线程是不可能给自己的中断状态置位的。这可能会产生一个InterruptedException异常。
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
	@Override
	public void run () {
		while(true){
			if(Thread.currentThread().isInterrupted()){
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

	public static void main (String[] args) throws InterruptedException {
		WorkThread worker = new WorkThread();
		Thread thread = new Thread(worker);
		thread.start();
		Thread.sleep(1000);
		thread.stop();
	}
}
