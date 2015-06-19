package ch60_80;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/1 0001.
 */
public class Ch77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<=n-k;i++){
            List<Integer> a = new ArrayList<>();
            a.add(i+1);
            List<List<Integer>> tempResult = doConbine(n,1,k,a);
            result.addAll(tempResult);
        }
        return result;
    }

   public List<List<Integer>>  doConbine(int n,int begin,int k,List<Integer> childList){
       List<List<Integer>> result = new ArrayList<>();
       if(begin==k){
           result.add(childList);
           return result;
       }

       for(int i=childList.get(childList.size()-1);i<=n-k+begin;i++){
           List<Integer> a = new ArrayList<>(childList);
           a.add(i + 1);
           List<List<Integer>> tempResult = doConbine(n,begin+1,k,a);
           result.addAll(tempResult);
       }
        return result;
   }

    public static void main(String[] args) {
        int n=3;
        int k=3;
        System.out.println(new Ch77().combine(n,k));
    }
}
