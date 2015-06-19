package ch60_80;

public class Ch74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int p1=0;int p2=matrix.length-1;
	
		while(matrix[p1][0]<=target&&matrix[p2][0]>target&&p2-p1>1){
			int mid = (p1+p2)/2;
			if(matrix[mid][0]>target){
				p2=mid;
			}
			if(matrix[mid][0]<=target){
				p1=mid;
			}
		}
		int row = 0;
		if(target>=matrix[p2][0]){
			row =p2;
		}else {
			row = p1;
		}
		p1=0;p2=matrix[row].length-1;
		while(matrix[row][p1]<=target&&matrix[row][p2]>target&&p2-p1>1){
			int mid = (p1+p2)/2;
			if(matrix[row][mid]>target){
				p2=mid;
			}
			if(matrix[row][mid]<=target){
				p1=mid;
			}
		}
		if(matrix[row][p1]==target)
			return true;
		if(matrix[row][p2]==target)
			return true;
		return false;
	}
	public static void main(String[] args) {
		for(int m=1;m<10;m++){
			for(int n=1;n<10;n++){
				int index = 1;
				int[][] matrix = new int[m][n];
				for(int i=0;i<m;i++){
					for(int j=0;j<n;j++){
						matrix[i][j] = index;
						index +=2;
					}
				}
				for(int i=0;i<m;i++){
					for(int j=0;j<n;j++){
						if(!new Ch74().searchMatrix(matrix, matrix[i][j])){
							System.out.println("m= "+m+" n= "+n+","+i+" ,"+j+", "+matrix[i][j]);
						}
					}
				}
			}
		}
		
	}
}
