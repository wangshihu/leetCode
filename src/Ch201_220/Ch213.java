package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch213 {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length<=3){
            int max = Integer.MIN_VALUE;
            for(int a:nums)
                max = Math.max(max,a);
            return max;
        }
        int r1 = doRob(nums,0,nums.length-2);
        int r2 = doRob(nums,1,nums.length-3)+nums[nums.length-1];
        return Math.max(r1,r2);
    }
    public int doRob(int[] nums,int begin,int end){
        if(begin==end)
            return nums[begin];
        int[] currentMaxArr = new int[nums.length];
        int[] containMaxArr = new int[nums.length];
        containMaxArr[begin] = currentMaxArr[begin] = nums[begin];
        containMaxArr[begin+1] = nums[begin+1];
        currentMaxArr[begin+1] = Math.max(nums[begin],nums[begin+1]);
        for(int i=begin+2;i<=end;i++){
            containMaxArr[i] = currentMaxArr[i-2]+nums[i];
            currentMaxArr[i] = Math.max(currentMaxArr[i-1],containMaxArr[i]);
        }
        return currentMaxArr[end];
    }

    public static void main(String[] args) {
        int[] nums = {7,6,8,11,22};
        System.out.println(new Ch213().rob(nums));
    }
}
