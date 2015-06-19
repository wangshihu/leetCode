package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch202 {
    public boolean isHappy(int n) {
        for(;n!=4&&n!=1;){
            n=sumSqrt(n);
        }
        if(n==1)
            return true;
        return false;
    }
    public int sumSqrt(int n){
        int result = 0;
        while(n!=0){
            int num = n%10;
            result += Math.pow(num,2);
            n/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        for(int i=100;i<4000;i++){
            System.out.println(i+"ÊÇ£º"+new Ch202().isHappy(i));
        }
    }
}
