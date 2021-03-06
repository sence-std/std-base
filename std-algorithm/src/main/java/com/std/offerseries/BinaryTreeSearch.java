/**
 * @FileName:BinaryTreeSearch
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/30/2015 2:10 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

import com.std.datastructure.link.NLinkList;
import com.std.datastructure.tree.BinaryTree;

/**
 *
 * <p>二叉树查找</p>
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
public class BinaryTreeSearch {

	/**
	 * 二叉树节点搜索
	 * @param bt
	 * @param num
	 * @param linkList
	 * @return
	 */
	public NLinkList search(BinaryTree<Integer> bt,int num,NLinkList linkList){
		if(linkList == null){
			linkList = new NLinkList();
		}
		if(bt == null || bt.isEmpty()){
			linkList = null;
			return linkList;
		}
		linkList.add(bt.getRootNode().getE());
		if(bt.getRootNode().getE()<num){
			return search(bt.getRootNode().getRightTree(),num,linkList);
		}
		if(bt.getRootNode().getE()>num){
			return search(bt.getRootNode().getLeftTree(),num,linkList);
		}
		return linkList;
	}

	/**
	 * 查找和为给的数据的路径
	 * @param bt
	 * @param sum
	 * @param nLinkList
	 * @return
	 */
	public void searchSum(BinaryTree<Integer> bt,int sum,NLinkList nLinkList){
		if(nLinkList == null){
			nLinkList = new NLinkList();
		}
		if(bt == null || bt.getRootNode().getE()>sum){
			nLinkList.remove();
			return ;
		}
		nLinkList.add(bt.getRootNode().getE());
		int _num = bt.getRootNode().getE();
		if(_num == sum){
			System.out.println(nLinkList);
			return ;
		}
		if(bt.getRootNode().getLeftTree()!=null) {
			searchSum(bt.getRootNode().getLeftTree(), sum - _num, nLinkList);
			nLinkList.remove();
		}
		if(bt.getRootNode().getRightTree()!=null) {
			searchSum(bt.getRootNode().getRightTree(), sum - _num, nLinkList);
			nLinkList.remove();
		}
	}



}
