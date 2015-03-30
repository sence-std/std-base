/**
 * @FileName:BinaryTreeSearch
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/30/2015 3:14 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.datastructure.link.NLinkList;
import com.std.datastructure.tree.BinaryTree;
import com.std.offerseries.BinaryTreeSearch;
import org.junit.Test;

/**
 *
 * <p>二叉树查找测试</p>
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
public class BinaryTreeSearchTest {


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
		BinaryTreeSearch btSearch = new BinaryTreeSearch();
		NLinkList nLinkList = btSearch.search(bt,10,null);
		System.out.print(nLinkList);
	}

	@Test
	public void test01(){
		BinaryTree bt = new BinaryTree();
		bt.add(16);
		bt.add(8);
		bt.add(9);
		bt.add(4);
		bt.add(3);
		bt.add(10);
		bt.add(6);
		bt.add(12);
		bt.add(2);
		bt.add(20);
		bt.add(25);
		bt.add(17);
		bt.add(28);
		bt.add(19);
		bt.add(22);
		bt.add(32);
		BinaryTreeSearch search = new BinaryTreeSearch();
		search.searchSum(bt,43,null);
	}


}
