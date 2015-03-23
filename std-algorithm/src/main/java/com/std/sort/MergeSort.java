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
		ArrayUtil.printArray(this.arr, ",");
	}

	public void doMergeSort(int[] arr,int lowerBound,int upBound){
		if(lowerBound>=upBound){
			return;
		}
		int partition = (int)Math.ceil((upBound+lowerBound)/2*1.0);
		doMergeSort(arr,lowerBound,partition);
		doMergeSort(arr,partition+1,upBound);
        //此处必须partition+1 因为0-9时进行右边排序是从6开始的
		merge(arr,lowerBound,partition+1,upBound);
	}

	private void merge (int[] arr ,int lowerBound,int partition,int upBound) {
        int j = 0;
        int lowerPar = lowerBound;
		int mid = partition-1;
        int n = upBound-lowerBound+1;
        //分割后是从右边的第一个下标开始的
        while(lowerBound<=mid && partition<=upBound ){
            if(this.arr[lowerBound]<this.arr[partition]){
                arr[j++] = this.arr[lowerBound++];
            }else{
                arr[j++]=this.arr[partition++];
            }
        }
        while(lowerBound<=mid){
            arr[j++] = this.arr[lowerBound++];
        }
        while(partition<=upBound){
            arr[j++] = this.arr[partition++];
        }

        for(int i=0;i<n;i++){
            this.arr[lowerPar++] = arr[i];
        }
	}

}
