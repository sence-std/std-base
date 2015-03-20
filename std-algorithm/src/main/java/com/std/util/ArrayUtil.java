/**
 * @FileName:ArrayUtil
 * @Package: com.std.util
 *
 * @author sence
 * @created 3/20/2015 9:47 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.util;

/**
 *
 * <p>数组工具类</p>
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
public class ArrayUtil {

	/**
	 * 打印数据
	 */
	public static void printIntArray(int[] arr,String sep){
		for(int k=0;k<arr.length;k++){
			System.out.print(arr[k]);
			if(k != arr.length-1){
				System.out.print(sep);
			}
		}
		System.out.println();

	}



}
