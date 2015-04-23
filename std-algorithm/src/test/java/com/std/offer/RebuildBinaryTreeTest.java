/**
 * @FileName:RebuildBinaryTreeTest
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/27/2015 5:53 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.datastructure.tree.BinaryTree;
import com.std.offerseries.ReBuildBinaryTree;
import org.junit.Test;

/**
 *
 * <p>重建二叉树测试</p>
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
public class RebuildBinaryTreeTest {


	@Test
	public void test(){
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};
		ReBuildBinaryTree rbt = new ReBuildBinaryTree();
		BinaryTree bt = rbt.doRebuild(preOrder, inOrder);
		bt.printPreorderTree(bt);
	}

}
