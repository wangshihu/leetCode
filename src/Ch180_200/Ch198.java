package Ch180_200;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch198 {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] currentMaxArr = new int[nums.length];
        int[] containMaxArr = new int[nums.length];
        containMaxArr[0] = currentMaxArr[0] = nums[0];
        containMaxArr[1] = nums[1];
        currentMaxArr[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            containMaxArr[i] = currentMaxArr[i-2]+nums[i];
            currentMaxArr[i] = Math.max(currentMaxArr[i-1],containMaxArr[i]);
        }
        return currentMaxArr[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {5,8,2,7};
        System.out.println(new Ch198().rob(nums));
    }
}
