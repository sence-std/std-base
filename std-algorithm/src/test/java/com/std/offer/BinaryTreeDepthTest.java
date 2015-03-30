/**
 * @FileName:BinaryTreeDepthTest
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/30/2015 2:17 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.datastructure.tree.BinaryTree;
import com.std.offerseries.BinaryTreeDepth;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <p>二叉树深度</p>
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
public class BinaryTreeDepthTest {

	/**
	 *
	 */
	@Test
	public void test(){
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(5);
		bt.add(4);
		bt.add(8);
		bt.add(9);
		bt.add(10);
		bt.add(7);
		bt.add(1);
		bt.add(2);
		BinaryTreeDepth btd = new BinaryTreeDepth();
		int depth = btd.calDepth(bt);
		Assert.assertEquals(5,depth);
	}

}
