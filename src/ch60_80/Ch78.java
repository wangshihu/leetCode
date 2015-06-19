package ch60_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 2015/6/1 0001.
 */
public class Ch78 {
    public List<List<Integer>> subsets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nullList = new ArrayList<>();
        result.add(nullList);

        for(int i=0;i<arr.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            List<List<Integer>> tempResult = doSubsets(arr,i+1,list);
            result.add(list);
            result.addAll(tempResult);
        }

        return result;
    }

    public List<List<Integer>>  doSubsets(int[] arr,int begin,List<Integer> childList){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=begin;i<arr.length;i++){
            List<Integer> a = new ArrayList<>(childList);
            a.add(arr[i]);
            List<List<Integer>> tempResult = doSubsets(arr, i+1, a);
            result.add(a);
            result.addAll(tempResult);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        System.out.println(new Ch78().subsets(arr));
    }
}
