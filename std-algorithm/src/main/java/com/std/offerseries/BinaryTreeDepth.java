/**
 * @FileName:BinaryTreeDepth
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/30/2015 2:10 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

import com.std.datastructure.tree.BinaryTree;

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
public class BinaryTreeDepth {

	/**
	 * 递归求二叉树的深度
	 * @param tree
	 * @return
	 */
	public int calDepth(BinaryTree tree){
		if(tree == null || tree.isEmpty()){
			return 0;
		}
		int leftDepth = calDepth(tree.getRootNode().getLeftTree());
		int rightDepth = calDepth(tree.getRootNode().getRightTree());
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}

}
