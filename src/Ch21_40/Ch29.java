package Ch21_40;

/**
 * Created by hadoop on 2015/6/10 0010.
 */
public class Ch29 {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        int sign = 1;
        if(dividend<0) sign = -sign;
        if(divisor<0) sign = -sign;
        long temp = Math.abs((long)dividend);
        long temp2 = Math.abs((long)divisor);
        long c = 1;
        while(temp>temp2){
            temp2 = temp2<<1;
            c = c<<1;
        }
        int res = 0;
        while(temp>=Math.abs((long)divisor)){
            while(temp>=temp2){
                temp-=temp2;
                res+=c;
            }
            temp2 = temp2>>1;
            c=c>>1;
        }
        if(sign>0) return res;
        else return -res;
    }

    public static void main(String[] args) {

        System.out.println(new Ch29().divide(-2147483648,-1));
    }
}
