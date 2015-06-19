package Ch81_100;

import java.util.Stack;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]=='1')
                arr[0][j]=1;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]=='1')
                    arr[i][j] = 1+arr[i-1][j];
            }
        }
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int temp = largestRectangleArea(arr[i]);
            if(temp>max)
                max=temp;
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {"10".toCharArray(),"11".toCharArray(),"11".toCharArray()};
        System.out.println(new Ch85().maximalRectangle(matrix));
    }
}
