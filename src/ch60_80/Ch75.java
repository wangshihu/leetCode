package ch60_80;

class Ch75 {
	public void sortColors(int[] nums) {
		int[] arr = new int[3];
		for(int i=0;i<nums.length;i++){
			arr[nums[i]] += 1;
		}
		int index =0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i];j++){
				nums[index++] = i;
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {0};
		new Ch75().sortColors(nums);
	}
}
