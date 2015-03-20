/**
 * @FileName:ShellSort
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/20/2015 11:38 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

import com.std.util.ArrayUtil;

/**
 *
 * <p>希尔排序</p>
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
public class ShellSort {

	public void shellSort(int[] arr){
		int inner,outer;
		int temp;

		int h=1;
		while(h<arr.length/3){
			h=h*3+1;
		}
		while(h>0){
			for(outer=h;outer<arr.length;outer++){
				temp = arr[outer];
				inner = outer;
				while (inner>h-1&&arr[inner-h]>=temp){
					arr[inner] = arr[inner-h];
					inner -= h;
				}
				arr[inner] = temp;
				ArrayUtil.printIntArray(arr, ",");
			}
			h=(h-1)/3;
		}
	}

}
