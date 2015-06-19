package Ch41_60;

import java.util.ArrayList;
import java.util.List;

public class Ch52 {
	public int totalNQueens(int n) {
	       List<String[]> result = new ArrayList<String[]>();
	       int[] nums = new int[n];
	       for(int i=1;i<=n;i++){
	    	   nums[i-1] = i;
	       }
	       return permutation(nums, 0,result);
	}
	public String intArrToStr(int[] arr){
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]+" ");
		}
		sb.append("]");
		return sb.toString();
	}

	
	public boolean isvalid(int[] nums,int begin){
		for(int i=0;i<begin;i++){
			for(int j=i+1;j<begin;j++){
				if(Math.abs(i-j)==Math.abs(nums[i]-nums[j]))
					return false;
			}
		}
		return true;
	}
	
	
	public int permutation(int[] nums,int begin,List<String[]>list){
		if(!isvalid(nums, begin))
			return 0;
		if(begin==nums.length){
			return 1;
		}
		int result = 0;
		for(int i=begin;i<nums.length;++i){
			int temp =nums[i];
			nums[i] = nums[begin];
			nums[begin] = temp;
			result +=permutation(nums, begin+1,list);
			nums[begin] = nums[i];
			nums[i] = temp;
		}
		return result;
	}
	
	public static void main(String[] args) {
		for(int i=4;i<20;i++){
			int ak= new Ch52().totalNQueens(i);
			System.out.print(ak+" ");
		}
		
	}
}
