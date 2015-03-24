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
        knapsack(0,20,20,0);
    }

    public void knapsack(int start,int remain,int num,int level) {
		for(int i=start;i<arr.length;i++){
			if(ArrayUtil.sumArray(this.resArr,0,resArr.length-1)==num){
				return;
			}
			if(arr[i]>remain){
				continue;
			}
			resArr[level] = arr[i];
			knapsack(i+1,remain-arr[i],num,level+1);
		}
    }

    public static void main(String[] args) {
        int[] array = {9,4,6,8,7,5,2,1,3};
        Knapsack knapsack = new Knapsack(array,20);
		ArrayUtil.printArray(knapsack.resArr,",");
    }
}
