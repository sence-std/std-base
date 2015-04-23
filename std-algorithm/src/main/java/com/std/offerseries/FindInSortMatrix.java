/**
 * @FileName:FindInMatrix
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/27/2015 9:09 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

/**
 *
 * <p>
 *     二位有序数组查找数据
 * </p>
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
public class FindInSortMatrix {


	/**
	 * 查找对应的数字
	 * @param num
	 * @return
	 */
	public String find(int[][] sortMatrix ,int num){
		if(sortMatrix == null) return null;
		if(sortMatrix[0][0] > num) return null;
		int cols = sortMatrix[0].length;
		int rows = sortMatrix.length;
		int _col = cols>>1;
		while(true){
			if(_col == 0 || _col == cols-1){
				break;
			}
			if(sortMatrix[0][_col] == num){
				return "0-"+_col;
			}
			if(sortMatrix[0][_col]> num) {
				_col = (int)Math.floor(_col/2.0);
			}else{
				_col=(int)Math.ceil((_col+cols-1)/2.0);
			}
		}
		int _rows = 0;
		while(_col >= 0 && _rows < rows ){
			if(sortMatrix[_rows][_col]<num){
				_rows+=1;
				continue;
			}
			if(sortMatrix[_rows][_col]>num){
				_col-=1;
				continue;
			}
			if(sortMatrix[_rows][_col]==num){
				return _rows+"-"+_col;
			}

		}
		return null;
	}



}
