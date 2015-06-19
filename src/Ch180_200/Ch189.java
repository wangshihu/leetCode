package Ch180_200;

import com.huihui.util.ArrayUtil;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch189 {
    public void reverse(int[] nums,int begin,int end){
        for(;begin<end;begin++,end--){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
        }

    }
    public void rotate(int[] nums, int k) {
        k %=nums.length;
        if(nums==null||k<=0)
            return ;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Ch189().rotate(nums,3);
        System.out.println(ArrayUtil.arrToString(nums));
    }
}
