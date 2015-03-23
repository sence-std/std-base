/**
 * @FileName:ＷorkerTaskThread
 * @Package: com.std.thread
 *
 * @author sence
 * @created 3/19/2015 10:33 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.base;

/**
 *
 * <p>任务 详细见 WorkThread 头注释</p>
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
public class WorkerTaskThread implements Runnable{

	/***
	 * 任务
	 */
	private String task;
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
		long now = System.currentTimeMillis();
		int i=0;
		while(++i<10){
			System.out.println(1);
			// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
			// 此处用这种方法空转1秒
		}
		System.out.println(task);
	}

	public String getTask () {
		return task;
	}

	public void setTask (String task) {
		this.task = task;
	}


	public void runTask(String task){
		this.setTask(task);
	}
}
