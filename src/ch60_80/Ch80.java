package ch60_80;


import com.huihui.util.ArrayUtil;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int cNum = nums[0];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==cNum){
                if(num <2){
                    nums[index] = cNum;
                    index++;
                }
                num++;
            }else{
                cNum=nums[i];
                nums[index++] = nums[i];
                num=1;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,4,4,5,5,6,6,6};
        int k = new Ch80().removeDuplicates(nums);
        System.out.println(ArrayUtil.arrToString(nums, k));
    }
}
