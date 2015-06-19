package Ch101_120;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch115 {
    public int numDistinct(String s, String t) {
        if(s.equals(t))
            return 0;
        List<List<Integer>> indexList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        for(int j=0;j<s.length();j++){
            if(t.charAt(0)==s.charAt(j)){
                zeroList.add(j);
            }
        }
        indexList.add(zeroList);
        for(int i=1;i<t.length();i++){
            List<Integer> tempList = new ArrayList<>();
            List<Integer> preList = indexList.get(i-1);
            if(preList==null||preList.isEmpty())
                return 0;
            for(int j=preList.get(0);j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    tempList.add(j);
                }
            }
            indexList.add(tempList);
        }

        return dealIndexList(indexList,0,-1);
    }
    public int dealIndexList(List<List<Integer>> indexList,int listNum,int index) {
        if(listNum==indexList.size())
            return 1;
        List<Integer> tempList = indexList.get(listNum);
        int result = 0;

        for (Iterator<Integer> it = tempList.iterator();it.hasNext();) {
            int currentIndex = it.next();
            if (currentIndex > index) {
                int tempResult = dealIndexList(indexList, listNum + 1, currentIndex);
                if(tempResult==0)
                    return result;
                else
                    result+=tempResult;
            }else{
                //it.remove();
            }

        }
        return result;
    }

    public int numDistinct2(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int[][] nums = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s="adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        //System.out.println(new Ch115().numDistinct(s,t));
        System.out.println(new Ch115().numDistinct2(s,t));
//        List<Integer> list= new ArrayList<>();
//        for(int i=0;i<10;i++){
//            list.add(i);
//        }
//        for (Iterator<Integer> it = list.iterator();it.hasNext();) {
//            System.out.println(it.next());
//        }
    }
}
