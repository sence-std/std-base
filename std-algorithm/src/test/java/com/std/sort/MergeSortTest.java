/**
 * @FileName:MergeSortTest
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/23/2015 4:31 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import com.std.util.ArrayUtil;
import org.junit.Test;

/**
 *
 * <p>归并排序</p>
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
public class MergeSortTest {

	@Test
	public void test(){
		int[] array = {3,24,81,2,16,1,5,120,91,7};
		MergeSort mergeSort = new MergeSort(array);
		mergeSort.doSort();
		ArrayUtil.printArray(array,",");
	}
}
