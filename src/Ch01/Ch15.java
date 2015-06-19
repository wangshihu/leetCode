package Ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int tempSum = nums[i]+nums[j];
                int index = Arrays.binarySearch(nums,j+1,nums.length,tempSum*-1);
                if(index>-1){
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[i]);
                    tempResult.add(nums[j]);
                    tempResult.add(nums[index]);
                    result.add(tempResult);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] nums = {0,0,0,0,0,0,0};
        List<List<Integer>> result = new Ch15().threeSum(nums);
        System.out.println(result);
    }
}
