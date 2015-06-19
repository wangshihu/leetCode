package Ch201_220;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!queue.isEmpty()){
            counter++;
            Integer current = queue.poll();
            if(set[current]!=null){
                for(Integer a:set[current]){
                    requires[a]--;
                    if(requires[a]==0)
                        queue.add(a);
                }
            }

        }
        if(counter==numCourses)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{0,2},{1,0},{0,3},{4,2},{4,3}};
        System.out.println(new Ch207().canFinish(numCourses,prerequisites));
    }
}
