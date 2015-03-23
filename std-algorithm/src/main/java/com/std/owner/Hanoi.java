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

	int i=0;
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
			doTowers(diskN-1,from,to,inter);
			System.out.println("diskN [" + diskN + "] from [" + from + "] to [" + to + "]");
			doTowers(diskN - 1, inter, from, to);
		}
	}

	public static void main (String[] args) {
		Hanoi hanoi = new Hanoi(3);
	}

}
