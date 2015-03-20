/**
 * @FileName:QuickSortTest
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/20/2015 1:45 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import org.junit.Test;

/**
 *
 * <p>快速排序测试</p>
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
public class QuickSortTest {


	@Test
	public void test(){
		int[] array = {3,4,2,1,8,5,9,7,10,6};
		QuickSort quickSort = new QuickSort(array);
		quickSort.quickSort();
	}

}
