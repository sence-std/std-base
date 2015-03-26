/**
 * @FileName:NLinkList
 * @Package: com.std.datastructure.link
 *
 * @author sence
 * @created 3/26/2015 5:01 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure.link;

/**
 *
 * <p>单向链表</p>
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
public class NLinkList<E> {

	private NLink<E> firstLink;

	/**
	 * 往链表头加数据
	 * @param e
	 */
	public void addFirst(E e){
		if(e == null){
			return ;
		}
		NLink<E> waitAdd = new NLink<>(e);
		waitAdd.setNext(firstLink);
		firstLink = waitAdd;
	}

	/**
	 * 链表末尾
	 * @param e
	 */
	public void add(E e){
		if(e == null) {
			return;
		}
		NLink<E> waitAdd = new NLink<>(e);
		waitAdd.setNext(null);
		//空链表结构
		if(isEmpty()){
			firstLink = waitAdd;
		}else{
			//如果不是空链表，添加到链表的最后
			NLink<E> current = firstLink;
			while(current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(waitAdd);
		}
	}

	/**
	 * 删除俩表末端节点
	 */
	public void remove(){
		//空链表
		if(isEmpty()) return;
		//如果不是空链表，添加到链表的最后
		NLink<E> sCurrent = null;
		NLink<E> current = firstLink;
		while(current.getNext()!=null){
			sCurrent = current;
			current = current.getNext();
		}
		//链表只有一个节点
		if(sCurrent == null){
			firstLink = null;
		}else{
			sCurrent.setNext(null);
		}
	}

	/**
	 * 删除链表头节点
	 */
	public void removeFirst(){
		if(isEmpty()) return;
		firstLink = firstLink.getNext();
	}

	/**
	 * 链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return firstLink == null;
	}

	/**
	 * 打印整个链表
	 * @return
	 */
	@Override
	public String toString () {
		if(isEmpty()) return null;
		NLink<E> current = firstLink;
		StringBuffer sb = new StringBuffer();
		while(current.getNext()!=null){
			sb.append(current.getE()+",");
			current = current.getNext();
		}
		return sb.append(current.getE()).toString();
	}
}
