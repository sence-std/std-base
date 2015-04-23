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

import com.std.datastructure.tree.BinaryTree;
import com.std.datastructure.tree.Node;

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
	public BinaryTree doRebuild(int[] preOrder,int[] inOrder){
		if(preOrder == null || preOrder.length==0) return null;
		if(inOrder == null || inOrder.length==0) return null;
		int root = preOrder[0];
		Node rootNode = new Node(root);
		BinaryTree bt = new BinaryTree();
		if(preOrder.length==1 && inOrder.length == 1){
			bt.setRootNode(rootNode);
		}else {
			Integer index = findInOrderIndex(root,inOrder);
			if(index == null) return null;
			int[] leftInorder = getLeftInOrder(inOrder,index);
			int[] rightInorder = getRightInOrder(inOrder, index);
			int[] leftPreorder = getLeftPreOrder(preOrder, leftInorder.length);
			int[] rightPreorder = getRightPreOrder(preOrder, rightInorder.length);
			rootNode.setLeftTree(doRebuild(leftPreorder,leftInorder));
			rootNode.setRightTree(doRebuild(rightPreorder,rightInorder));
			bt.setRootNode(rootNode);
		}
		return bt;
	}

	private int[] getRightPreOrder (int[] preOrder, int length) {
		int[] preorder = new int[length];
		int k = 0;
		int st = preOrder.length-length;
		for(int i=st;i<preOrder.length;i++){
			preorder[k++] = preOrder[i];
		}
		return preorder;
	}

	private int[] getLeftPreOrder (int[] preOrder, int length) {
		int[] preorder = new int[length];
		int k = 0;
		for(int i=1;i<length+1;i++){
			preorder[k++] = preOrder[i];
		}
		return preorder;
	}

	private int[] getLeftInOrder (int[] inOrder, Integer index) {
		int[] inorder = new int[index];
		for(int i=0;i<index;i++){
			inorder[i] = inOrder[i];
		}
		return inorder;
	}

	private int[] getRightInOrder (int[] inOrder, Integer index) {
		int[] inorder = new int[inOrder.length-index-1];
		int k = 0;
		for(int i=index+1;i<inOrder.length;i++){
			inorder[k++] = inOrder[i];
		}
		return inorder;
	}

	private Integer findInOrderIndex (int root, int[] inOrder) {
		for(int i=0;i<inOrder.length;i++){
			if(inOrder[i]==root){
				return i;
			}
		}
		return null;
	}


}
