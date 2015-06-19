package ch60_80;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch72 {
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null)
            return 0;

        Map<String,Integer> map = new HashMap<>();
        return doMinDistance(word1,word2,0,0,word1.length()-1,word2.length()-1,map);
    }
    public int doMinDistance(String word1,String word2,int b1,int b2,int e1,int e2,Map<String,Integer> map){
        String key = new StringBuilder().append(b1).append(e1).append(b2).append(e2).toString();//生成key用于缓存
        Integer result = map.get(key);
        if(result!=null)
            return result;
        if(b1>e1||b2>e2){
            if(b1<=e1)
                result= e1-b1+1;
            else if(b2<=e2)
                result= e2-b2+1;
            else
                result= 0;
        }else{
            if(word1.charAt(b1)==word2.charAt(b2))
                result= doMinDistance(word1, word2, b1+1, b2+1, e1, e2,map);
            else {
                int t1 = doMinDistance(word1, word2, b1+1, b2, e1, e2,map);
                int t2 = doMinDistance(word1, word2, b1, b2+1, e1, e2,map);
                int t3 = doMinDistance(word1, word2, b1+1, b2+1, e1, e2,map);
                result =  Math.min(Math.min(t1,t2),t3)+1;
            }
        }
        map.put(key,result);
        return result;
    }

    public static void main(String[] args) {
//        String word1 = "abceok";
//        String word2 = "acdell";
        String word1 = "aa";
        String word2 = "";
        System.out.println(new Ch72().minDistance(word1,word2));
    }
}
