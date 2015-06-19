package ch121_140;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch123 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        List<Integer> list = new ArrayList<>();
        boolean first = true;
        for(int i=1;i<prices.length;i++){
            int num =prices[i]-prices[i-1];
            if(num>0||!first){
                first =false;
                list.add(num);
            }
        }
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)<=0)
                list.remove(i);
            else
                break;
        }

        int result = -1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)<0){
                int num = maxChildArray(list,0,i-1)+maxChildArray(list,i+1,list.size()-1);
                if(num>result){
                    result = num;
                }
            }
        }
        if(result==-1)
            return maxChildArray(list,0,list.size()-1);
        return result;
    }
    public int maxChildArray(List<Integer> list,int begin,int end){
        //最大连续子数组之和
        int all =0;
        int max =0;
        for(int i=begin;i<=end;i++){
            all+=list.get(i);
            if(all<0)
                all=0;
            if(all>max)
                max=all;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {6,1,3,2,4,7};
        System.out.println(new Ch123().maxProfit(arr)+", 7");
        int[] arr1 = {3,3,5,0,0,3,1,4};
        System.out.println(new Ch123().maxProfit(arr1)+", 6");
        int[] arr2 = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        System.out.println(new Ch123().maxProfit(arr2)+", 11");

    }
}
