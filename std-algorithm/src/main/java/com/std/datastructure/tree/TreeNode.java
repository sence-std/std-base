/**
 * @FileName:TreeNode
 * @Package: com.std.datastructure.tree
 *
 * @author sence
 * @created 3/30/2015 5:08 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure.tree;

import java.util.List;

/**
 *
 * <p>树节点</p>
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
public class TreeNode<E extends Comparable> {

	/**
	 * 节点值
	 */
	private E e;

	/**
	 * 子树
	 */
	private List<Tree> childTrees;

	public void setE (E e) {
		this.e = e;
	}

	public E getE () {
		return e;
	}



}
