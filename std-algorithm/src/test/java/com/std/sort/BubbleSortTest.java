/**
 * @FileName:BubbleSortTest
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/20/2015 9:36 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import org.junit.Test;

/**
 *
 * <p>冒泡排序测试</p>
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
public class BubbleSortTest {

	/**
	 * 冒泡排序
	 * 依据测试结果来看，冒泡排序是可以改良的
	 * 如下： 长度为n的数组 需要排序n-1次 有时候存在m 使得n-1-m次时 排序就已经排好了 所以可以做一些改良
	 *
	 */
	@Test
	public void testBubble(){
		int[] array = {3,4,2,1,6,8,5,9,7,10};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.doSortDesc(array);
		System.out.println("************************************");
		bubbleSort.doSortAsc(array);
	}
}
