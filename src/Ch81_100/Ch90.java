package Ch81_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch90 {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nullList = new ArrayList<>();
        result.add(nullList);

        for(int i=0;i<arr.length;i++){
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> tempResult = new ArrayList<>();
            list.add(arr[i]);
            if(i<arr.length-1&&arr[i]!=arr[i+1]){
                tempResult = doSubsets(arr,i+1,list);
            }
            result.add(list);
            result.addAll(tempResult);
        }

        return result;
    }

    public List<List<Integer>>  doSubsets(int[] arr,int begin,List<Integer> childList){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=begin;i<arr.length;i++){
            List<Integer> a = new ArrayList<>(childList);
            List<List<Integer>> tempResult = new ArrayList<>();
            a.add(arr[i]);
            if(i<arr.length-1&&arr[i]!=arr[i+1]){
                tempResult = doSubsets(arr, i+1, a);
            }
            result.add(a);
            result.addAll(tempResult);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,2};
        System.out.println(new Ch90().subsetsWithDup(arr));
    }
}
