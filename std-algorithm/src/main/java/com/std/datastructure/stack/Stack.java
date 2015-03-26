/**
 * @FileName:Stack
 * @Package: com.std.datastructure
 *
 * @author sence
 * @created 3/26/2015 4:34 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>
 *     栈结构
 *     后进先出
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
public class Stack<E> {


	/**基于数组完成*/
	private List<E> list;


	/**
	 *
	 * @return
	 */
	public boolean isEmpty(){
		return list == null || list.size()==0;
	}

	/**
	 * 将数据压入栈顶
	 * @param e
	 */
	public void push(E e){
		if(isEmpty()){
			list = new ArrayList<>();
		}
		list.add(e);
	}

	/**
	 * 弹出栈顶元素
	 * @return
	 */
	public E pop(){
		if(isEmpty()){
		return null;
		}
		int size = list.size();
		E e = list.get(size-1);
		list.remove(size-1);
		return e;
	}

	/**
	 * 查看栈顶元素，但是不弹出此元素
	 * @return
	 */
	public E peek(){
		if(isEmpty()){
			return null;
		}
		return list.get(list.size()-1);
	}

	@Override
	public String toString () {
		return list.toString();
	}
}
