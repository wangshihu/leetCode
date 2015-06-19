package ch60_80;

public class Ch73 {
	static int spNum = 954567128;
	public void setZeroes(int[][] matrix) {
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==0){
					deal(matrix, i,j);
				}
				if(matrix[i][j]==spNum){
					matrix[i][j]=0;
				}
			}
		}
	}
	public void deal(int[][] matrix,int row,int col){
		for(int i=0;i<matrix[row].length;i++){
			if(i<=col){
				matrix[row][i]=0;
				continue;
			}
			if(matrix[row][i]!=0){
				matrix[row][i]=spNum;
			}
		}
		for(int j=0;j<matrix.length;j++){
			if(j<=row){
				matrix[j][col]=0;
				continue;
			}
			if(matrix[j][col]!=0){
				matrix[j][col]=spNum;
			}
		}
		
	}
	
}
