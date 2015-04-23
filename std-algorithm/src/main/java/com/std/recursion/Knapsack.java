package com.std.recursion;

import com.std.datastructure.link.NLinkList;
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

	public Knapsack(){

	}

	/**
	 * 这个方法简单暴力，但是只能找一个
	 * @param start
	 * @param remain
	 * @param num
	 * @param level
	 */
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

	/**
	 * 这个方法可以改造后找所有的可能(这里只查找了第一个满足条件的)
	 * @param array
	 * @param start
	 * @param num
	 * @param nLinkList
	 * @return
	 */
	public boolean knapsackOne(int[] array ,int start,int num,NLinkList nLinkList) {
		if(nLinkList == null){
			nLinkList = new NLinkList();
		}
		for(int i=start;i<array.length;i++){
			if(array[i]>num){
				continue;
			}
			nLinkList.add(array[i]);
			if(array[i] == num){
				System.out.println(nLinkList);
				return true;
			}
			if(knapsackOne(array,i+1,num-array[i],nLinkList)){
				return true;
			}
			nLinkList.remove();
		}
		return false;
	}

	/**
	 * 这个方法找所有的满足条件的可能
	 * @param array
	 * @param start
	 * @param num
	 * @param nLinkList
	 */
	public void knapsackAll(int[] array ,int start,int num,NLinkList nLinkList) {
		if(nLinkList == null){
			nLinkList = new NLinkList();
		}
		for(int i=start;i<array.length;i++){
			if(array[i]>num){
				continue;
			}
			nLinkList.add(array[i]);
			if(array[i] == num){
				System.out.println(nLinkList);
			}
			knapsackAll(array,i+1,num-array[i],nLinkList);
			nLinkList.remove();
		}
	}


	public static void main(String[] args) {
        int[] array = {9,4,6,8,7,5,2,1,3};
        Knapsack knapsack = new Knapsack(array,20);
		ArrayUtil.printArray(knapsack.resArr,",");
    }
}
