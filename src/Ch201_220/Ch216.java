package Ch201_220;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch216 {
    int n;
    int end;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int tempSum =0;
        for(int i=1;i<=k-1;i++)
            tempSum+=i;
        this.end = 9;
        this.n = n;
        if(end<k||k<1)
            return result;
        if(k==1){
            List<Integer> temp = new ArrayList<>();
            temp.add(n);
            result.add(temp);
            return  result;
        }
        for(int i=1;i<=end-k+1;i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            doCombinationSum3(k - 1, i, n - i, list);
        }
        return result;
    }
    public void doCombinationSum3(int k,int currentNum,int need,List<Integer> currentList){
        if(k==1){
            if(need>currentNum&&need<=end){
                List<Integer> temp = new ArrayList<>(currentList);
                temp.add(need);
                result.add(temp);
            }
            return ;
        }
        for(int i=currentNum+1;i<=end-k+1;i++){
            currentList.add(new Integer(i));
            doCombinationSum3(k - 1, i, need - i, new ArrayList<Integer>(currentList));
            currentList.remove(new Integer(i));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Ch216().combinationSum3(2,17);
        System.out.println(result);

    }
}
