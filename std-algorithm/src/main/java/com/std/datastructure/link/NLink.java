/**
 * @FileName:Link
 * @Package: com.std.datastructure
 *
 * @author sence
 * @created 3/26/2015 4:35 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure.link;

import java.io.Serializable;

/**
 *
 * <p>单向链表节点</p>
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
public class NLink<E> implements Serializable {

	private static final long serialVersionUID = -1821993889934875493L;

	private E e;
	private NLink<E> next;

	public NLink(){

	}

	public NLink(E e){
		this.e = e;
	}

	public E getE () {
		return e;
	}

	public void setE (E e) {
		this.e = e;
	}

	public NLink<E> getNext () {
		return next;
	}

	public void setNext (NLink<E> next) {
		this.next = next;
	}

}
