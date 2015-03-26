/**
 * @FileName:Anagram
 * @Package: com.std.owner
 *
 * @author sence
 * @created 3/23/2015 11:10 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.recursion;

import com.std.util.ArrayUtil;

/**
 *
 * <p>使用递归进行字符变位</p>
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
public class Anagram {

	/**
	 * 字符数字
	 */
	private char[] chs;

	public Anagram(){

	}
	public Anagram (String str) {
		chs = str.toCharArray();
		doAnagram(chs.length);
	}

	/**
	 *
	 */
	public void doAnagram(int length){
		if(length == 1){
			ArrayUtil.printArray(chs, "");
			return;
		}else{
			for(int i=0;i<length;i++) {
				doAnagram(length - 1);
				/**轮换*/
				rourate(length);
			}

		}

	}

	private void rourate (int length) {
		char temp = chs[chs.length-length];
		for(int i=chs.length-length+1;i<chs.length;i++){
			chs[i-1] = chs[i];
		}
		chs[chs.length-1] = temp;
	}

	public static void main (String[] args) {
		new Anagram("catso");
	}

}
