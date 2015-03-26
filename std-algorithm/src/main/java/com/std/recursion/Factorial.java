/**
 * @FileName:Factorial
 * @Package: com.std.owner
 *
 * @author sence
 * @created 3/23/2015 1:34 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.recursion;

/**
 *
 * <p>递归求阶乘</p>
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
public class Factorial {

	/**
	 *  阶乘
	 * @param n
	 * @return
	 */
	public long doFactorial(int n){
		if(n == 0){
			return 1;
		}else{
			return n*doFactorial(n - 1);
		}
	}

	/**
	 * 三角数字
	 * @param n
	 * @return
	 */
	public long doRangle(int n){
		if(n == 0){
			return 0;
		}else{
			return n+doRangle(n - 1);
		}
	}

	public static void main (String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.doFactorial(10));
		System.out.print(f.doRangle(10));
	}
}
