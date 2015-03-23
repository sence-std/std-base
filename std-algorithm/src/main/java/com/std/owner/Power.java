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
     * @param x
     * @param y
     * @return
     */
    public int doPower(int x,int y){
        if(y==1){
            return x;
        }
        if(y%2!=0){
            return x*doPower(x*x, y / 2);
        }else {
            return doPower(x*x, y / 2);
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
        System.out.println(p.doPower(3, 18));
        System.out.println(p.doPower2(3, 18));
    }
}
