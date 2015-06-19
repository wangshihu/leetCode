package Ch01;


import java.util.Arrays;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch01 {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=0;
        boolean flag = false;
        for(i=0;i<nums.length;i++){
            for(j=0;j<nums.length;j++){
                if(i!=j&&nums[i]+nums[j]==target){
                   flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        int[] result = {i+1,j+1};
        return result;
    }

    /**
     * 这个方法更完美，复杂度O(nlogn)
     * 不过需要排序前的坐标，懒得写这种排序了 - 。
     */
    public int[] p(int[] nums,int target){
        Arrays.sort(nums);
        int i=0,j=0;
        for(;i>j;){
            if(nums[i]+nums[j]>target){
                j--;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                break;
            }
        }
        int[] result = {i,j};
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        new Ch01().twoSum(nums,6);
    }
}
