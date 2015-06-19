package ch60_80;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch69 {
    public int climbStairs(int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<=n;i++)
            arr[i] = arr[i-1]+arr[i-2];
        return arr[n];
    }
}
