package Ch201_220;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch205 {
    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null||s.length()!=t.length())
            return false;
        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            Character character = map.get(t.charAt(i));
            if(character==null){
                map.put(t.charAt(i),s.charAt(i));
                if(set.contains(s.charAt(i)))
                    return false;
                else
                    set.add(s.charAt(i));
            }
            else{
                if(character!=s.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Ch205().isIsomorphic("egg","add")+", true");
        System.out.println(new Ch205().isIsomorphic("foo", "bar")+", false");
        System.out.println(new Ch205().isIsomorphic("paper", "title")+", true");
        System.out.println(new Ch205().isIsomorphic("ab", "aa")+", false");
    }
}
