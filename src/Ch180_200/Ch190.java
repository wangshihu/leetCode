package Ch180_200;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch190 {
    public int reverseBits(int n) {
        long result = n;
        int max = 0xffffffff;
        for(int i=0;i<16;i++){
            long low = (long)Math.pow(2,i);
            long high =(long) Math.pow(2,31-i);
            long lowNum = result&low;
            long highNum = n&high;
            if(lowNum==low)
                result = result|high;
            else
                result=result&(max-high);
            if(highNum==high)
                result= result|low;
            else
                result = result&(max-low);
        }
        return (int)result;
    }



    public static void main(String[] args) {

    }
}
