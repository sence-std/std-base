/**
 * @FileName:BinaryTree
 * @Package: com.std.datastructure.tree
 *
 * @author sence
 * @created 3/27/2015 3:07 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure.tree;

/**
 *
 * <p>二叉树</p>
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
public class BinaryTree<E extends Comparable> {

	private Node<E> rootNode;

	/**
	 * 添加子节点
	 * @param e
	 */
	public BinaryTree add(E e){
		if(isEmpty()){
			rootNode = new Node(e);
			return this;
		}
		Node current = rootNode;
		while(true) {
			if(current == null){
				current = new Node(e);
				break;
			}
			if (current.getE().compareTo(e) < 0) {
				if(current.getRightTree()!=null){
					current = current.getRightTree().rootNode;
				}else{
					current.setRightTree(new BinaryTree().add(e));
					break;
				}
			}
			if (current.getE().compareTo(e) > 0) {
				if(current.getLeftTree()!=null){
					current = current.getLeftTree().rootNode;
				}else{
					current.setLeftTree(new BinaryTree().add(e));
					break;
				}
			}
		}
		return this;
	}

	public boolean isEmpty(){
		return rootNode == null;
	}
	/**
	 * 先序遍历
	 * @return
	 */
	public void printPreorderTree(BinaryTree binaryTree){
		if(binaryTree == null || binaryTree.isEmpty()){
			System.out.print("");
			return;
		}
		System.out.print(binaryTree.getRootNode().getE()+" ");
		printPreorderTree(binaryTree.getRootNode().getLeftTree());
		printPreorderTree(binaryTree.getRootNode().getRightTree());
	}

	/**
	 * 中序遍历
	 * @return
	 */
	public void printInorderTree(BinaryTree binaryTree){
		if(binaryTree == null || binaryTree.isEmpty()){
			System.out.print("");
			return;
		}
		printInorderTree(binaryTree.getRootNode().getLeftTree());
		System.out.print(binaryTree.getRootNode().getE()+" ");
		printInorderTree(binaryTree.getRootNode().getRightTree());
	}

	/**
	 * 后序遍历
	 * @return
	 */
	public void printSuforderTree(BinaryTree binaryTree){
		if(binaryTree == null || binaryTree.isEmpty()){
			System.out.print("");
			return;
		}
		printSuforderTree(binaryTree.getRootNode().getLeftTree());
		printSuforderTree(binaryTree.getRootNode().getRightTree());
		System.out.print(binaryTree.getRootNode().getE()+" ");
	}

	public Node<E> getRootNode () {
		return rootNode;
	}

}
