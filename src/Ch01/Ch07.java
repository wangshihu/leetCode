package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch07 {
    public void p(int x){
    }


    public int reverse(int x) {
        if(x==Integer.MIN_VALUE){
            return reverse((x+1)*-1)*-1;
        }
        if(x<0){
            return reverse(x*-1)*-1;
        }

        long factor = 1;
        int[] arr =new int[16];
        for(int i=0;i<arr.length;i++){
            arr[i] = -1;
        }
        int i=0;
        while(x!=0){
            int current = x%10;
            arr[i] = current;
            i++;
            x=x/10;
        }
        long result = 0;
        for(i-=1;i>=0;i--){
            result += arr[i]*factor;
            factor*=10;
            if(result>Integer.MAX_VALUE)
                return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int a= 1534236469;
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(a*-1);
        System.out.println(new Ch07().reverse(1534236469));
    }
}
