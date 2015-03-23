/**
 * @FileName:SelectionSort
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/19/2015 6:05 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import com.std.util.ArrayUtil;

/**
 *
 * <p>选择排序算法</p>
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
public class SelectionSort {

	/**
	 * 选择排序 升序 时间复杂度O(n^2)
	 * @param arr
	 */
	public void doSortAsc(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int tempIndex = i;
			//找出第（i+1）小的
			for(int j=i+1;j<arr.length;j++){
				if(arr[tempIndex]>arr[j]){
					tempIndex = j;
				}
			}
			//交换
			int temp = arr[i];
			arr[i] = arr[tempIndex];
			arr[tempIndex] = temp;
			ArrayUtil.printArray(arr,",");
		}
	}

	/**
	 * 选择排序 升序 时间复杂度O(n^2)
	 * @param arr
	 */
	public void doSortDesc(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int tempIndex = i;
			//找出第（i+1）小的
			for(int j=i+1;j<arr.length;j++){
				if(arr[tempIndex]<arr[j]){
					tempIndex = j;
				}
			}
			//交换
			int temp = arr[i];
			arr[i] = arr[tempIndex];
			arr[tempIndex] = temp;
			ArrayUtil.printArray(arr,",");
		}
	}


}
