/**
 * @FileName:QuickSort
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/20/2015 11:41 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import com.std.util.ArrayUtil;

/**
 *
 * <p>快速排序</p>
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
public class QuickSort {


	private int[] arr = null;

	public QuickSort (int[] arr) {
		this.arr = arr;
	}
	/**
	 * 快速排序
	 */
	public void quickSort(){
		reQuickSort(0,arr.length-1);
	}

	private void reQuickSort(int left,int right){
		if(right-left<=0){
			return;
		}else {
			int poivt = this.arr[right];
			int partition = paritionArr(left, right, poivt);
			ArrayUtil.printIntArray(arr, ",");
			reQuickSort(left, partition - 1);
			reQuickSort(partition + 1, right);
		}
	}

	private int paritionArr (int left, int right, int poivt) {
		int leftPar = left-1;
		int rightPar = right;
		while(true){
			while(arr[++leftPar]<poivt){

			}
			while(arr[--rightPar]>poivt && rightPar>0){

			}
			if(leftPar>=rightPar){
				break;
			}else{
				swap(leftPar,rightPar);
			}
		}
		swap(leftPar,right);
		return leftPar;
	}

	private void swap(int index1,int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
