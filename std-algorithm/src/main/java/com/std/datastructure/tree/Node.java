/**
 * @FileName:Node
 * @Package: com.std.datastructure.tree
 *
 * @author sence
 * @created 3/26/2015 4:38 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure.tree;

/**
 *
 * <p>节点数据</p>
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
public class Node<E extends Comparable> {

	private E e;

	private BinaryTree<E> leftTree;

	private BinaryTree<E> rightTree;


	public Node(){

	}

	public Node(E e){
		this.e = e;
	}

	public E getE () {
		return e;
	}

	public void setE (E e) {
		this.e = e;
	}

	public BinaryTree<E> getRightTree () {
		return rightTree;
	}

	public void setRightTree (BinaryTree<E> rightTree) {
		this.rightTree = rightTree;
	}

	public BinaryTree<E> getLeftTree () {
		return leftTree;
	}

	public void setLeftTree (BinaryTree<E> leftTree) {
		this.leftTree = leftTree;
	}
}
