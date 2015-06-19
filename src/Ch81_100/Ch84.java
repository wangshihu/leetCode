package Ch81_100;

import java.util.Stack;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch84 {
    public int largestRectangleArea(int[] height) {
        int[][] arr = new int[height.length][];

        for(int i=0;i<height.length;i++){
            if(height[i]==Integer.MAX_VALUE)
                return height[i];
            int[] ak = new int[height[i]+1];
            arr[i] = ak;
            if(i==0){//初始化第一个
                for(int j=1;j<ak.length;j++){
                    ak[j] = j;
                }
            }else{
                for(int j=1;j<ak.length;j++){
                    if(arr[i-1].length>j){
                        arr[i][j] = arr[i-1][j]+j;
                    }else{
                        arr[i][j] = j;
                    }
                }
            }

        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(max<arr[i][j])
                    max = arr[i][j];
            }
        }
        return max;
    }

    public int largestRectangleArea2(int[] height) {
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

    public static void test1(int[] hegiht){
        long beginTime = System.currentTimeMillis();
        new Ch84().largestRectangleArea(hegiht);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }
    public static void test2(int[] hegiht){
        long beginTime = System.currentTimeMillis();
        new Ch84().largestRectangleArea2(hegiht);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }

    public static void main(String[] args) {
        int[] hegiht = {2, 1, 5, 6, 2, 3};
        int[] hegiht2 = new int[11000];
        for(int i=0;i<hegiht2.length;i++){
            hegiht2[i] = 1;
        }
//        test1(hegiht2);
//        test2(hegiht2);
        System.out.println(new Ch84().largestRectangleArea2(hegiht));
    }
}
