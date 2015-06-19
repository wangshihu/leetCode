package ch121_140;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch122 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int result =0;
        for(int i=1;i<prices.length;i++){
            int temp = prices[i]-prices[i-1];
            if(temp>0)
                result+=temp;
        }
        return result;
    }
}
