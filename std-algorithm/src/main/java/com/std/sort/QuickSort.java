/**
 * @FileName:QuickSort
 * @Package: com.std.sort
 * @author sence
 * @created 3/20/2015 11:41 AM
 * <p>
 * Copyright 2011-2015 Asura
 */
package com.std.sort;

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

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 快速排序
     */
    public void quickSort() {
        reQuickSort(0, arr.length - 1);
    }

    /**
     * 快速排序
     * @param left
     * @param right
     */
    private void reQuickSort(int left, int right) {
        if (left == right) {
            return;
        }
        int partition = partitionArr(left, right);
        if(partition > left) {
            reQuickSort(left, partition - 1);
        }
        if(right>partition) {
            reQuickSort(partition + 1, right);
        }
    }

    private int partitionArr(int left, int right) {
        int povit = arr[right];
        int rightPtr = right;
        int leftPtr = left - 1;
        while (true) {
            while (leftPtr < right && arr[++leftPtr] < povit) {
            }
            while (rightPtr > left && arr[--rightPtr] > povit) {
            }
            if (leftPtr >= rightPtr) {
                break;
            }
            swap(leftPtr, rightPtr);
        }
        // 交换poivt
        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int i, int right) {
        int a = arr[i];
        arr[i] = arr[right];
        arr[right] = a;
    }


}
