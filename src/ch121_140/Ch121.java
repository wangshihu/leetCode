package ch121_140;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch121 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int[] arr = new int[prices.length-1];
        for(int i=0;i<arr.length;i++){
            arr[i] = prices[i+1]-prices[i];
        }
        //最大连续子数组之和

        int all =0;
        int max =0;
        for(int i=0;i<arr.length;i++){
            all+=arr[i];
            if(all<0)
                all=0;
            if(all>max)
                max=all;
        }
        return max;
    }
}
