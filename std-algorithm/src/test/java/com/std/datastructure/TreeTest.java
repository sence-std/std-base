/**
 * @FileName:TreeTest
 * @Package: com.std.datastructure
 *
 * @author sence
 * @created 3/27/2015 3:57 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure;

import com.std.datastructure.tree.BinaryTree;
import org.junit.Test;

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
public class TreeTest {


	@Test
	public void test(){
		BinaryTree bt = new BinaryTree();
		bt.add(10);
		bt.add(5);
		bt.add(9);
		bt.add(11);
		bt.add(18);
		bt.add(2);
		bt.add(7);
		bt.add(17);
		bt.printPreorderTree(bt);
		System.out.println();
		bt.printInorderTree(bt);
		System.out.println();
		bt.printSuforderTree(bt);
		System.out.println();
	}


}
