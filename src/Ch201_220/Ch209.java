package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int sum = 0;
        int end = 0;
        int begin = 0;
        int size = 0;
        int min = Integer.MAX_VALUE;
        for(;end<nums.length;end++){
            sum+=nums[end];
            if(sum<s){
                continue;
            }else {
                size=end-begin+1;
                while(sum-nums[begin]>=s){
                    sum -=nums[begin];
                    begin++;
                    size--;
                }
                min = Math.min(min,size);
            }
        }
        if(min==Integer.MAX_VALUE)
            return 0;
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new Ch209().minSubArrayLen(100,nums));
    }
}
