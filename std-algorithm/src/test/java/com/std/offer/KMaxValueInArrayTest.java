/**
 * @FileName:KMaxValueInArrayTest
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/30/2015 4:21 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.offerseries.KMaxValueInArray;
import org.junit.Test;

/**
 *
 * <p>查找数组中第K大的数字测试</p>
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
public class KMaxValueInArrayTest {

	@Test
	public void test(){
		int[] array = {12,42,17,34,22,92,21,63,50};
		KMaxValueInArray kvi = new KMaxValueInArray();
		int val = kvi.findKMax(array,6);
		System.out.print(val);
	}

}
