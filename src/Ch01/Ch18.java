package Ch01;

import java.util.*;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> result = new HashSet<>();
        if(nums==null||nums.length<4)
            return new ArrayList<>(result);
        Arrays.sort(nums);
       for(int i=0;i<nums.length-3;i++){
           for(int j=i+1;j<nums.length-2;j++){
               for(int k=j+1;k<nums.length-1;k++){
                   int sum = nums[i]+nums[j]+nums[k];
                   int index = Arrays.binarySearch(nums,k+1,nums.length,target-sum);
                   if(index>0){
                       List<Integer> tempResult = new ArrayList<>();
                       tempResult.add(nums[i]);
                       tempResult.add(nums[j]);
                       tempResult.add(nums[k]);
                       tempResult.add(nums[index]);
                       result.add(tempResult);
                   }

               }
           }
       }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> result = new Ch18().fourSum(nums,target);
        System.out.println(result);
    }
}
