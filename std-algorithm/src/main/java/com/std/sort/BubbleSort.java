/**
 * @FileName:BubbleSort
 * @Package: com.std.sort
 *
 * @author sence
 * @created 3/19/2015 6:04 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

/**
 *
 * <p>冒泡排序算法</p>
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
public class BubbleSort {

	/**
	 * 排序降序 时间复杂度O(n^2)
	 * @param t
	 * @return
	 */
	public int[] doSortDesc(int[] t){
		for(int i=0;i<t.length-1;i++){
            for(int j=0;j<t.length-i-1;j++){
                if(t[j]<t[j+1]){
                    int temp = t[j];
                    t[j] = t[j+1];
                    t[j+1] = temp;
                }
            }
            for(int k=0;k<t.length;k++){
                System.out.print(t[k]);
                if(k != t.length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        return t;
	}

    /**
     * 排序 升序
     * @param t
     * @return
     */
    public int[] doSortAsc(int[] t){
        for(int i=0;i<t.length-1;i++){
            for(int j=0;j<t.length-i-1;j++){
                if(t[j]>t[j+1]){
                    int temp = t[j];
                    t[j] = t[j+1];
                    t[j+1] = temp;
                }
            }
            for(int k=0;k<t.length;k++){
                System.out.print(t[k]);
                if(k != t.length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        return t;
    }

    public static void main(String[] args) {
        int[] array = {3,4,2,1,6,8,5,9,7,10};
        BubbleSort bubbleSort = new BubbleSort();
      //  int[] arr = bubbleSort.doSortDesc(array);

        int[] arr = bubbleSort.doSortAsc(array);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+",");
//        }
    }

}
