/**
 * @FileName:StackTest
 * @Package: com.std.datastructure
 *
 * @author sence
 * @created 3/26/2015 6:05 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure;

import com.std.datastructure.stack.Stack;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * <p>stack栈</p>
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
public class StackTest {



	@Test
	public void testPop(){
		Stack stack = new Stack();
		stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int i = (Integer)stack.pop();
		Assert.assertEquals(3,i);
		Assert.assertEquals("[1, 2]",stack.toString());
	}

	@Test
	public void testPeek(){
		Stack stack = new Stack();
		stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Assert.assertEquals(3,stack.peek());
	}
}
