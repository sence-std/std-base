/**
 * @FileName:ReBuildTree
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/27/2015 2:56 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

/**
 *
 * <p>
 *     重建二叉树
 * </p>
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
public class ReBuildBinaryTree {

	/**
	 * 先序遍历 和 中序遍历
	 * @param preOrder
	 * @param inOrder
	 */
	public void doRebuild(int[] preOrder,int[] inOrder){
		if(preOrder == null || preOrder.length==0) return;
		if(inOrder == null || inOrder.length==0) return;
		int root = preOrder[0];
	}

}
