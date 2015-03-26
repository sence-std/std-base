/**
 * @FileName:PrintNum
 * @Package: com.std.owner
 *
 * @author sence
 * @created 3/26/2015 10:19 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.recursion;

import com.std.util.ArrayUtil;

/**
 *
 * <p>
 *
 *     打印数字
 *	   输入数字n 打印从 1-n位的最大数字
 *	   比如 3 则打印 1，2，3...999
 *
 *	   主要考察的是　数据的溢出处理
 *
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
public class PrintNum {


	private int[] num;
	/**
	 *
	 */
	public void print1TOMaxNum(int n){
		if(n==0) printNum(null,n);
		int _n = n;
		if(n<0){
			_n=Math.abs(n);
		}
		num = new int[_n+1];
		while(!incrementNum(num,_n)){
			printNum(num,n);
		}
	}

	/**
	 * 增加num
	 * @param num
	 * @return
	 */
	private boolean incrementNum (int[] num,int index) {
		if(num[index] < 10){
			num[index] += 1;
		}
		if(num[0] == 1){
			return true;
		}
		if(num[index] == 10){
			num[index] = 0;
			return incrementNum(num,index-1);
		}
		return false;
	}

	/**
	 * 打印数字
	 * @param num
	 */
	private void printNum (int[] num,int n) {
		if(num == null){
			System.out.print("0");
		}else {
			if(n<0){
				System.out.print("-");
				ArrayUtil.printArray(num, "",1,Math.abs(n)+1);
			}else {
				ArrayUtil.printArray(num, "",1,Math.abs(n)+1);
			}
		}
	}

	public static void main (String[] args) {
		PrintNum printNum = new PrintNum();
		printNum.print1TOMaxNum(8);
	}

}
