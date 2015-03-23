/**
 * @FileName:ThrowDice
 * @Package: com.std.owner
 *
 * @author sence
 * @created 3/20/2015 3:40 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.owner;

/**
 *
 * <p>投骰子计算可能数</p>
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
public class ThrowDice {

	/**
	 * 投骰子 点数为1-6 总共投了n次，得了m点数
	 *
	 * DP(n,m)=DP(n-1,m-1)+DP(n-1,m-2)+DP(n-1,m-3)+DP(n-1,m-4)+DP(n-1,m-5)+DP(n-1,m-6)
	 *
	 *
	 * 如 n=10 m=50
	 *
	 * 则 DP(10,50)=DP(9,49)+DP(9,48)+DP(9,47)+DP(9,46)+DP(9,45)+DP(9,44)
	 * 即为 投掷9次的得到49点的次数+投掷9次的得到48点的次数+投掷9次的得到47点的次数+投掷9次的得到46点的次数+投掷9次的得到45点的次数+投掷9次的得到44点的次数
	 *
	 *
	 */
	public static int dpThorwDice(int thN,int sum){

		if(thN == 1 ) {
			//递归得到的结果 如果点数在1-6之间 则为有效投掷，返回投掷有效1次
			if( 1<=sum && sum<=6 ) {
				return 1;
			}else {
				return 0;
			}
		}
		return dpThorwDice(thN-1,sum-1)
				+ dpThorwDice(thN-1,sum-2)
				+ dpThorwDice(thN-1,sum-3)
				+ dpThorwDice(thN-1,sum-4)
				+ dpThorwDice(thN-1,sum-5)
				+ dpThorwDice(thN-1,sum-6);

	}

	public static void main (String[] args) {
		System.out.println(dpThorwDice(10,50));
	}

}
