/**
 * @FileName:FindInSortMatrix
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/27/2015 9:30 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.offerseries.FindInSortMatrix;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <p>二维数组查找</p>
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
public class FindInSortMatrixTest {


	@Test
	public void test(){
		int[][] smatrix = {{1,3,5,7,8},{3,4,6,8,9},{4,6,8,10,11},{5,7,9,12,15},{6,10,13,14,16}};
		int num = 10;
		FindInSortMatrix fim = new FindInSortMatrix();
		Assert.assertEquals("2-3",fim.find(smatrix, num));
	}

}
