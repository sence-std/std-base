/**
 * @FileName:PrintNLinkListTest
 * @Package: com.std.offer
 *
 * @author sence
 * @created 3/27/2015 2:26 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offer;

import com.std.datastructure.link.NLinkList;
import com.std.offerseries.PrintNLinkList;
import org.junit.Test;

/**
 *
 * <p>倒叙打印链表</p>
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
public class PrintNLinkListTest {


	@Test
	public void test(){
		NLinkList linkList = new NLinkList();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		PrintNLinkList pnl = new PrintNLinkList();
		pnl.printLinkList(linkList);
	}

	@Test
	public void test01(){
		NLinkList linkList = new NLinkList();
		PrintNLinkList pnl = new PrintNLinkList();
		pnl.printLinkList(linkList);
	}

	@Test
	public void test02(){
		PrintNLinkList pnl = new PrintNLinkList();
		pnl.printLinkList(null);
	}

}
