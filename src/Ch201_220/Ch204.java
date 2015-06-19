package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch204 {
    public int countPrimes(int n) {
        n--;
        if(n<2)
            return 0;
        boolean[] arr = new boolean[(n-1)/2];
        for(int i=0;(i+2)*2-1<=Math.sqrt(n);i++){
            if(!arr[i]){
                for(int j=i+(i+2)*2-1;j<arr.length;j+=(i+2)*2-1){
                    arr[j] = true;
                }
            }
        }
        int num =1;
        for(int i=0;i<arr.length;i++){
            if(!arr[i])
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(new Ch204().countPrimes(n));
    }
}

