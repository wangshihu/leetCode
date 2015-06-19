package ch121_140;

/**
 * Created by hadoop on 2015/6/7 0007.
 */
public class Ch136 {
    public int singleNumber(int[] nums) {
        if(nums==null)
            return 0;
        int result = 0;
        for(int i :nums){
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(new Ch136().singleNumber(nums));
    }
}
