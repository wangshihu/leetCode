package Ch41_60;

import java.util.ArrayList;
import java.util.List;

public class Ch51 {
	public List<String[]> solveNQueens(int n) {
	       List<String[]> result = new ArrayList<String[]>();
	       int[] nums = new int[n];
	       for(int i=1;i<=n;i++){
	    	   nums[i-1] = i;
	       }
	       permutation(nums, 0,result);
	       return result;
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
	
	public String[] drawQueen(int[] nums){
		String[] result = new String[nums.length];
		for(int i=0;i<nums.length;i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<nums.length;j++){
				if(j==nums[i]-1){
					sb.append('Q');
				}else {
					sb.append('.');
				}
			}
			result[i] = sb.toString();
		}
		return result;
	}
	
	public void permutation(int[] nums,int begin,List<String[]>list){
		if(!isvalid(nums, begin))
			return ;
		if(begin==nums.length){
			list.add(drawQueen(nums));
			return ;
		}
		//List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=begin;i<nums.length;++i){
			int temp =nums[i];
			nums[i] = nums[begin];
			nums[begin] = temp;
			permutation(nums, begin+1,list);
			nums[begin] = nums[i];
			nums[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		for(int i=4;i<20;i++){
			List<String[]> ak= new Ch51().solveNQueens(i);
			System.out.print(ak.size()+" ");
		}
		
	}
}
