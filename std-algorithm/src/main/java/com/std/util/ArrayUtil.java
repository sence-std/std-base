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
	public static void printArray(int[] arr,String sep){
		for(int k=0;k<arr.length;k++){
			System.out.print(arr[k]);
			if(k != arr.length-1){
				System.out.print(sep);
			}
		}
		System.out.println();

	}

	/**
	 * 打印数据
	 */
	public static void printArray(int[] arr,String sep,int start,int end){
		for(int k=start;k<end;k++){
			System.out.print(arr[k]);
			if(k != arr.length-1){
				System.out.print(sep);
			}
		}
		System.out.println();

	}

    public static int sumArray(int[] arr,int st,int end){
        if(st==end){
            return arr[end];
        }
        return arr[st]+sumArray(arr,st+1,end);
    }

	/**
	 * 打印数据
	 */
	public static void printArray(char[] arr,String sep){
		for(int k=0;k<arr.length;k++){
			System.out.print(arr[k]);
			if(k != arr.length-1){
				System.out.print(sep);
			}
		}
		System.out.println();

	}

    public static void main(String[] args) {
        int[] array = {3,4,2,1,6,8,5,9,7,10};
        System.out.println(sumArray(array,0,3));
    }
}
