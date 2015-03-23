/**
 * @FileName:Hanoi
 * @Package: com.std.owner
 *
 * @author sence
 * @created 3/23/2015 3:06 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.owner;

/**
 *
 * <p>经典的汉诺塔问题</p>
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
public class Hanoi {

	/**
	 *
	 * @param diskNum
	 */
	public Hanoi(int diskNum){
		doTowers(diskNum,"A","B","C");
	}

	/**
	 *
	 * @param diskN
	 * @param from
	 * @param inter
	 * @param to
	 */
	public void doTowers(int diskN,String from ,String inter,String to){
		if(diskN==1){
			System.out.println("diskN ["+diskN+"] from [" + from + "] to ["+to+"]");
		}else{
			//将小的移到中间过渡塔座上
			doTowers(diskN-1,from,to,inter);
			//将最大的移动到目的塔座
			System.out.println("diskN [" + diskN + "] from [" + from + "] to [" + to + "]");
			//将小的从中间塔座移动到目的塔座
			doTowers(diskN - 1, inter, from, to);
		}
	}

	public static void main (String[] args) {
		new Hanoi(4);
	}

}
