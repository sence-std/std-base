/**
 * @FileName:WorkThreadTest
 * @Package: com.std.thread
 *
 * @author sence
 * @created 3/19/2015 10:04 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.base;

import org.junit.Test;

/**
 *
 * <p>测试中断</p>
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
public class WorkThreadTest {

	@Test
	public void test() throws InterruptedException {
		WorkThread worker = new WorkThread();
		Thread thread = new Thread(worker);
		thread.start();
		Thread.sleep(10);
		thread.interrupt();
	}

	@Test
	public void testBolck() throws InterruptedException {
		WorkThreadBlock worker = new WorkThreadBlock();
		Thread thread = new Thread(worker);
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
	}

	@Test
	public void testWorker() throws InterruptedException {
		ＷorkerTaskThread worker = new ＷorkerTaskThread();
		worker.runTask("task 1 ...");
		Thread thread = new Thread(worker);
		thread.start();
		Thread.sleep(2000);
		System.out.println(thread);
		worker.runTask("task 2...");
		System.out.println(thread);
		thread.interrupt();
		System.out.println(thread);
		System.out.println(thread);

	}

}
