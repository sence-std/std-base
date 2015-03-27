/**
 * @FileName:ＭoveBlankSpace
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/27/2015 11:50 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

/**
 *
 * <p>替换字符串的空格</p>
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
public class MoveBlankSpace {

	/**
	 * 替换字符串的空格
	 * @param str
	 */
	public String moveSpace(String str){
		if(str == null || "".equals(str)) return null;
		int spaceNum = 0;
		for(int i=0;i<str.length();i++){
			if(' ' == str.charAt(i)){
				spaceNum+=1;
			}
		}
		int new_length = str.length()+(spaceNum<<1);
		char[] ch = new char[new_length];
		int newLast = new_length;
		for(int i=str.length()-1;i>=0;i--){
			if(' ' == str.charAt(i)){
				ch[--newLast] = '0';
				ch[--newLast] = '2';
				ch[--newLast] = '%';
			}else{
				ch[--newLast] = str.charAt(i);
			}
		}
		return new String(ch);
	}

}
