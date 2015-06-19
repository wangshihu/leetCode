package ch121_140;

import java.util.*;

/**
 * Created by hadoop on 2015/6/8 0008.
 */
public class Ch139 {
    static  Map<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null)
            return false;
        int max = Integer.MIN_VALUE;
        for(String str:wordDict){
            max = Math.max(max,str.length());
        }
        return doWordBreak(s,wordDict,max);
    }
    public boolean doWordBreak(String s, Set<String> wordDict,int max) {
        if(s.length()==0)
            return true;

        Boolean result =map.get(s);
        if(result==null)
            result = false;
        else
            return result;
        for(int i=Math.min(s.length(), max);i>0;i--){
            if(wordDict.contains(s.substring(0,i))){
                if(doWordBreak(s.substring(i),wordDict,max)){
                    result = true;
                    break;
                }

            }
        }
        map.put(s,result);
        return result;
    }


    public static void main(String[] args) {
        String[] arr = {"a"};
        Set<String> wordDict = new HashSet<String>();
        Collections.addAll(wordDict,arr);
       // String s ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String s = "a";
        System.out.println(new Ch139().wordBreak(s, wordDict));
    }
}
