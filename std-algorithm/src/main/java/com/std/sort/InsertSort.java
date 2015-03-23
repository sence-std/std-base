/**
 * @FileName:InsertSort
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/19/2015 6:06 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import com.std.util.ArrayUtil;

/**
 *
 * <p>插入排序算法</p>
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
public class InsertSort {

	/**
	 * 插入排序升序
	 */
	public void doSortAsc(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index = i+1;
			while(index>0){
				if(arr[index-1]>arr[index]){
					int temp = arr[index-1];
					arr[index-1] = arr[index];
					arr[index] = temp;
					index--;
					continue;
				}else{
					break;
				}
			}
			ArrayUtil.printArray(arr,",");
		}
	}

	/**
	 * 插入排序 降序
	 * @param arr
	 */
	public void doSortDesc(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index = i+1;
			while(index>0){
				if(arr[index-1]<arr[index]){
					int temp = arr[index-1];
					arr[index-1] = arr[index];
					arr[index] = temp;
					index--;
					continue;
				}else{
					break;
				}
			}
			ArrayUtil.printArray(arr,",");
		}
	}

}
