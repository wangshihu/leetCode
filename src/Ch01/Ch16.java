package Ch01;

import java.util.Arrays;

/**
 * Created by hadoop on 2015/6/10 0010.
 */
public class Ch16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)
            return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target)
                    return sum;
                if(sum>target)
                    right--;
                if(sum<target)
                    left++;
                close = Math.abs(sum-target)<Math.abs(close)?sum-target:close;
            }
        }
        return close+target;
    }

    public static void main(String[] args) {
        int[] nums ={-1,2,1,-4};
        System.out.println(new Ch16().threeSumClosest(nums,1));
    }
}
