/**
 * @FileName:PrintNLinkList
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/27/2015 1:54 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

import com.std.datastructure.link.NLink;
import com.std.datastructure.link.NLinkList;
import com.std.datastructure.stack.Stack;

/**
 *
 * <p>
 *     从头到尾打印单向链表
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
public class PrintNLinkList {

	/**
	 * 从头到尾打印单向链表
	 */
	public void printLinkList(NLinkList linkList){
		if(linkList == null || linkList.isEmpty()){
			System.out.print("");
			return;
		}
		Stack stack = new Stack();
		pushLinkListToStack(linkList,stack);
		while(stack.peek()!=null){
			System.out.print(stack.pop()+",");
		}

	}

	private void pushLinkListToStack (NLinkList linkList, Stack stack) {
		NLink current = linkList.getFirstLink();
		while (current.getNext()!=null){
			stack.push(current.getE());
			current = current.getNext();
		}
		stack.push(current.getE());
	}

}
