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


	private int[] arr;

	/**
	 * 归并排序
	 * @param arrs
	 */
	public MergeSort(int[] arrs){
		this.arr = arrs;
		int[] ws = new int[arrs.length];
		doMergeSort(ws,0,arr.length-1);
		//ArrayUtil.printArray(ws, ",");
	}

	public void doMergeSort(int[] arr,int lowerBound,int upBound){
		if(lowerBound>=upBound){
			return;
		}
		int partition = (int)Math.ceil((upBound+lowerBound)/2*1.0);
		doMergeSort(arr,lowerBound,partition);
		ArrayUtil.printArray(arr,",");
		doMergeSort(arr,partition+1,upBound);
		merge(arr,lowerBound,partition,upBound);
	}

	private void merge (int[] arr ,int lowerBound,int partition,int upBound) {
		int li = lowerBound;
		int ri = partition;
		for(int i=0;i<upBound-lowerBound;i++){
			if(li == partition && ri < upBound){
				arr[i] = this.arr[ri];
				ri++;
				continue;
			}
			if(ri == upBound && li < partition){
				arr[i] = this.arr[li];
				ri++;
				continue;
			}
			if(ri < partition && li < upBound) {
				if (this.arr[li] <=this.arr[ri]) {
					arr[i] = this.arr[li];
					li++;
				} else {
					arr[i] = this.arr[ri];
					ri++;
				}
			}
		}
	}

	public static void main (String[] args) {
		System.out.print(Math.ceil((1 - 0) * 1.0 / 2 * 1.0));
	}
}
