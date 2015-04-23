/**
 * @FileName:KnapsackTest
 * @Package: com.std.recursion
 *
 * @author sence
 * @created 3/30/2015 6:03 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.recursion;

import org.junit.Test;

/**
 *
 * <p>背包测试</p>
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
public class KnapsackTest {



	@Test
	public void test(){
		Knapsack knapsack = new Knapsack();
		int[] array = {9,4,6,8,7,5,2,1,3};
		knapsack.knapsackOne(array,0,20,null);
		System.out.println("********************************");
		knapsack.knapsackAll(array,0,20,null);
	}


}
