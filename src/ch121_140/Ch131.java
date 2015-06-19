package ch121_140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch131{
    static Map<String,List<List<String>>> map =new HashMap<>();

    public List<List<String>> partition(String s) {
        List<List<String>> result = map.get(s);
        if(result!=null){
            result = copy(result);
            return result;
        }
        else{
            result = new ArrayList<>();
        }
        if(s==null)
            return result;
        for(int i=1;i<s.length();i++){
            String preStr = s.substring(0,i);
            if(isPalindrome(preStr)){
                List<List<String>> tempResult = partition(s.substring(i));
                for(List<String> temp:tempResult){
                    temp.add(0,preStr);
                }
                result.addAll(tempResult);
            }
        }
        if(isPalindrome(s)){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            result.add(temp);
        }
        map.put(s,copy(result));
        return result;
    }

    public List<List<String>> copy(List<List<String>> copyed){
        List<List<String>> result = new ArrayList<>();
        for(List<String> temp:copyed){
            result.add(new ArrayList<String>(temp));
        }
        return result;
    }

    public boolean isPalindrome(String s){
        if(s.length()==1)
            return true;
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="seeslaveidemonstrateyetartsnomedievalsees";
        System.out.println(new Ch131().partition(s).size());
    }
}
