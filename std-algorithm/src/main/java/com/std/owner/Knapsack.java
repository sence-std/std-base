package com.std.owner;

import com.std.util.ArrayUtil;

/**
 * @ file_name Knapsack
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/3/23 22:06
 * @ description 背包问题
 * @ review by
 */
public class Knapsack {

    private int[] arr;
    private int[] resArr;
    public Knapsack(int[] arrs,int num){
        this.arr = arrs;
        this.resArr = new int[this.arr.length];
        knapsack(this.arr,0,20,20);
    }
    /**
     *
     */
    public boolean knapsack(int[] arr, int start, int left, int sum) {

        if (arr.length == 0) {
            return false;
        }

        // start from the next item in original array
        if (start ==this.arr.length) {
            int[] tempArr = new int[arr.length - 1];
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i] = arr[i + 1];
            }
            return knapsack(tempArr, 0, sum, sum);
        } else if (arr[start] > left) {
            return knapsack(arr, start + 1, left, sum);
        } else if (arr[start] == left) {
            for (int i = 0; i < start + 1; i++) {
                // print the answer out
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
            return true;
        } else {
            return knapsack(arr, start + 1, left - arr[start], sum);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,5,6,7,8,9,10};
        Knapsack knapsack = new Knapsack(array,20);
        ArrayUtil.printArray(knapsack.resArr,",");
    }
}
