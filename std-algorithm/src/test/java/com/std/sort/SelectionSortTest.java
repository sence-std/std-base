/**
 * @FileName:SelectionSortTest
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/20/2015 9:45 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import org.junit.Test;

/**
 *
 * <p>选择排序</p>
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
public class SelectionSortTest {

	@Test
	public void test(){
		int[] array = {3,4,2,1,6,8,5,9,7,10};
		SelectionSort sort = new SelectionSort();
		sort.doSortAsc(array);
		System.out.println("************************************");
		sort.doSortDesc(array);
	}


}
