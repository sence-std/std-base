/**
 * @FileName:NLinkListTest
 * @Package: com.std.datastructure
 *
 * @author sence
 * @created 3/26/2015 5:35 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure;

import com.std.datastructure.link.NLinkList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <p>单向链表测试</p>
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
public class NLinkListTest{

	@Test
	public void testAdd() {
		NLinkList linkList = new NLinkList();
		linkList.add(null);
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		Assert.assertEquals(linkList.isEmpty(),false);
		Assert.assertEquals(linkList.toString(), "1,2,3");
		linkList.addFirst(0);
		Assert.assertEquals(linkList.toString(), "0,1,2,3");
	}

	@Test
	public void testRemove() {
		NLinkList linkList = new NLinkList();
		linkList.remove();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.remove();
		linkList.removeFirst();
		Assert.assertEquals(linkList.toString(), "2");
	}

}
