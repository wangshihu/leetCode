package Ch180_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        if(s==null||s.length()<11)
            return result;
        Integer key = 0;
        for(int i=0;i<10;i++){
            key = ((key<<3)|(s.charAt(i)&0x7))& 0x3fffffff;//第33位自动没了。
        }
        map.put(key,1);
        for (int i = 10; i < s.length(); i++) {
            key =((key<<3)|(s.charAt(i)&0x7))& 0x3fffffff;
            Integer num = map.get(key);
            if (num == null)
                map.put(key, 1);
            else if(num==1) {
                map.put(key, num + 1);
                result.add(s.substring(i-9,i+1));
            }

        }
        return result;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
            if (i < 9) continue;
            if (map.get(key) == null) {
                map.put(key, 1);
            } else if (map.get(key) == 1) {
                ans.add(s.substring(i - 9, i + 1));
                map.put(key, 2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "GAGAGAGAGAGA";
        System.out.println(new Ch187().findRepeatedDnaSequences(s));
    }
}
