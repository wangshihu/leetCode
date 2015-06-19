package Ch41_60;

public class Ch50 {
	 public int maxSubArray(int[] nums) {
		 int max = Integer.MIN_VALUE;
		 int all = 0;
		 for (int i = 0; i < nums.length; i++) {
			all = all + nums[i];
			if (all>= max) {
				max = all;
			}
			if (all < 0) {
				all = 0;
			}
		}
		 return max;
	 }
	 public static void main(String[] args) {
		int[] nums = {-1};
		System.out.println(new Ch50().maxSubArray(nums));
	}
}
