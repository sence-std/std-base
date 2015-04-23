/**
 * @FileName:KMaxValueInArray
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/30/2015 3:45 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

/**
 *
 * <p>
 *     O(n)数组中第K大的数字
 *     快速排序
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
public class KMaxValueInArray {

	/**
	 * 查找数组中第K大
	 * @return
	 */
	public Integer findKMax(int[] array,int k){
		if(array == null){
			return null;
		}
		if(array.length < k || k<1){
			return null;
		}
		int start = 0;
		int end = array.length-1;
		int index = partitionNum(array,start,end);
		while(index != k-1){
			if(index>k-1){
				end = index-1;
				index = partitionNum(array,start,end);
			}else{
				start = index + 1;
				index = partitionNum(array,start,end);
			}
		}
		return array[index];
	}

	private int partitionNum (int[] array,int start,int end) {
		int partNum = array[end];
		start = start - 1;
		int rightPar = end;
		while(true){
			while(array[++start]<partNum && start<end){

			}
			while(array[--end]>partNum && end > 0){

			}
			if(start>=end){
				break;
			}
			swap(array,start,end);
		}
		swap(array,start,rightPar);
		return start;
	}

	private void swap (int[] array, int start, int end) {
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}

}
