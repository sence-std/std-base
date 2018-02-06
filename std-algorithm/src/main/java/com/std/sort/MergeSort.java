/**
 * @FileName:MergeSort
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/20/2015 11:39 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import com.std.util.ArrayUtil;

/**
 *
 * <p>
 *	   归并排序思想：将数组分成两个比较小的数组，然后对两个比较小的数组进行合并排序
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
public class MergeSort {

	private int arr[];

	public MergeSort(int arr[]){
		this.arr = arr;
	}
	/**
	 *
	 */
	public void doSort(){
		int newarr[] = new int[arr.length];
		doSort(newarr,0,arr.length-1);
	}

	public int[] getResult(){
		return arr;
	}

	private void doSort(int[] newarr, int start, int end) {
		if(start == end) {
			return;
		}
		int partition = (end + start) /2;
		doSort(newarr,start,partition);
		doSort(newarr,partition+1,end);
		merge(newarr,start,partition,end);
	}

	private void merge(int[] newarr, int start, int partition, int end) {
		//开始合并
		int j = 0;
		int lower = start;
		int upStart = partition+1;
		while(lower<=partition && upStart<=end){
			if(arr[lower]> arr[upStart]){
				newarr[j++] = arr[upStart++];
			}else{
				newarr[j++] = arr[lower++];
			}
		}
		while (lower<=partition){
			newarr[j++] = arr[lower++];
		}
		while (upStart<=end){
			newarr[j++] = arr[upStart++];
		}
		int k =0;
		while(k<j){
			arr[start++] = newarr[k++];
		}
	}


}
