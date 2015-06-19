import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ch17 {
    public List<String> letterCombinations(String digits) {
        if(digits==null){
            return null;
        }
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        Map<Character,char[]> map=new HashMap<Character, char[]>();
        String word = "abcdefghijklmnopqrstuvwxyz";
        for(int i=2;i<=9;i++){
            if(i==7||i==9){
                map.put((char)(i+48), word.substring(0, 4).toCharArray());
                word = word.substring(4);
            }else{
                map.put((char)(i+48), word.substring(0, 3).toCharArray());
                word = word.substring(3);
            }
        }
        List<String> result = new ArrayList<String>();
        char[] arr = digits.toCharArray();
        char[] tempArr = map.get(arr[0]);
        for(int i=0;i<tempArr.length;i++){
            result.add(String.valueOf(tempArr[i]));
        }
        for(int i=1;i<arr.length;i++){
            tempArr = map.get(arr[i]);
            List<String> tempList = new ArrayList<String>();
            for(String r:result){
                for(int j=0;j<tempArr.length;j++){
                    tempList.add(r+String.valueOf(tempArr[j]));
                }
            }
            result = tempList;
        }
        return result;
    }
    public void printMap(Map<Character,char[]> map){
        for(Entry<Character, char[]> entry:map.entrySet()){
            char[] mapArr = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for(int i=0;i<mapArr.length;i++){
                sb.append(mapArr[i]+",");
            }
            sb.append("}");
            System.out.println(entry.getKey()+" "+sb.toString());
        }
    }
    public static void main(String[] args) {
        List<String> result = new Ch17().letterCombinations("23");
        for(String s:result){
            System.out.print(s+" ");
        }
    }
}