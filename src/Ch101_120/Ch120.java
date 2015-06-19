package Ch101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.isEmpty())
            return 0;
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            List<Integer> currentList = triangle.get(i);
            List<Integer> preList = triangle.get(i-1);
            currentList.set(0,currentList.get(0)+preList.get(0));
            currentList.set(currentList.size()-1,currentList.get(currentList.size()-1)+preList.get(preList.size() - 1));
            for(int j=1;j<currentList.size()-1;j++){
                currentList.set(j,Math.min(preList.get(j-1),preList.get(j))+currentList.get(j));
            }
        }
        int result = Integer.MAX_VALUE;
        List<Integer> lastList = triangle.get(triangle.size()-1);
        for(int i=0;i<lastList.size();i++){
            result = Math.min(result,lastList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> tempList = new ArrayList<>();
            for(int j=0;j<arr[i].length;j++){
                tempList.add(arr[i][j]);
            }
            triangle.add(tempList);
        }
        System.out.println(new Ch120().minimumTotal(triangle));
    }
}
