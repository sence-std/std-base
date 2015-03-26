package com.std.owner;

/**
 * @ file_name Power
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/3/23 21:41
 * @ description
 * @ review by
 */
public class Power {

    /**
     * 乘方 使用乘法 递归
	 * 1 确保代码的鲁棒性
	 * 2 确保可扩展性
     * @param x
     * @param y
     * @return
     */
    public double doPower(double x,int y){
		if(x == 0){
			return 0;
		}
		if(x==1){
			return 1;
		}
		int _y = y;
		if(y<0){
			_y = Math.abs(y);
		}
		double result = calPower(x,_y);
		if(y<0){
			return 1/result;
		}else{
			return result;
		}

    }

	public double calPower(double x,int y){
		if(y==0){
			return 1;
		}
		if(y==1){
			return x;
		}
		if((y & 0x1)==1){
			return x * calPower(x * x, y >> 1);
		}else {
			return calPower(x*x,y >> 1);
		}

	}

    public int doPower2(int x,int y){
        if(y==1){
            return x;
        }
        return x*doPower2(x,y-1);
    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.doPower(2, -3));
    }
}
