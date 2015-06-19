package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch215 {
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        for(int i=0;i<100;i++){
            nums[i] = 100-i;
        }
        System.out.println(new Ch215().findKthLargest(nums,90));
    }
}
