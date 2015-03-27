/**
 * @FileName:MoveBlankSpaceTest
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/27/2015 1:43 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.offerseries.MoveBlankSpace;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <p>移除空格 O(n)</p>
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
public class MoveBlankSpaceTest {

	@Test
	public void test(){
		MoveBlankSpace mbs = new MoveBlankSpace();
		String str1 = mbs.moveSpace(" ");
		Assert.assertEquals("%20",str1);
		String str2 = mbs.moveSpace("");
		Assert.assertEquals(null,str2);
		String str3 = mbs.moveSpace(null);
		Assert.assertEquals(null,str3);
		String str = mbs.moveSpace("i am happy ");
		Assert.assertEquals("i%20am%20happy%20",str);
	}

}
