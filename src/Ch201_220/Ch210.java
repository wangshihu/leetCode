package Ch201_220;

import com.huihui.util.ArrayUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] set = new HashSet[numCourses];
        int[] requires = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(set[prerequisites[i][0]]==null){
                set[prerequisites[i][0]] = new HashSet<>();
            }
            if(!set[prerequisites[i][0]].contains(prerequisites[i][1])){
                set[prerequisites[i][0]].add(prerequisites[i][1]);
                requires[prerequisites[i][1]]+=1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<requires.length;i++){
            if(requires[i]==0)
                queue.add(i);
        }
        int counter =0;
        int[] result  = new int[numCourses];
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            result[counter++] =current ;
            if(set[current]!=null){
                for(Integer a:set[current]){
                    requires[a]--;
                    if(requires[a]==0)
                        queue.add(a);
                }
            }

        }
        if(counter!=numCourses)
            return new int[0];
        for (int begin=0,end=result.length-1; begin < end; begin++, end--) {
            int temp = result[begin];
            result[begin] = result[end];
            result[end] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        //int[][] prerequisites = {{0,2},{1,0},{0,3},{4,2},{4,3}};
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(ArrayUtil.arrToString(new Ch210().findOrder(numCourses,prerequisites)));
    }
}
