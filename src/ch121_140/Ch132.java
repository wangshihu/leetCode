package ch121_140;

/**
 * Created by hadoop on 2015/6/6 0006.
 */
public class Ch132 {
//    static Map<String,Integer> map =new HashMap<>();
//    public int minCut(String s) {
//        Integer result = map.get(s);
//        if(result!=null)
//            return result;
//        else
//            result = 0;
//        if(s==null||isPalindrome(s))
//            return result;
//        for(int i=1;i<s.length();i++){
//            String preStr = s.substring(0,i);
//            int min =9999;
//            if(isPalindrome(preStr)){
//                int tempResult = minCut(s.substring(i))+1;
//                min = Math.min(min,tempResult);
//            }
//            if(min!=9999){
//                result = min;
//            }
//
//        }
//        map.put(s,result);
//        return result;
//    }

    public int minCut(String s) {
        int[][] arr = new int[s.length()][s.length()];
        for(int m=1;m<s.length();m++){
            for(int i=0;i+m<s.length();i++){
                if(isPalindrome(s.substring(i,i+m+1)))
                    continue;
                int min = Integer.MAX_VALUE;
                for(int j=i;j<i+m;j++){
                    min = Math.min(arr[i][j]+arr[j+1][i+m]+1,min);
                }
                arr[i][i+m] = min;
            }
        }
        return arr[0][s.length()-1];
    }

    public boolean isPalindrome(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return  false;
            }
        }
        return true;
    }

    public int minCut2(String s) {
        int min = 0;
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        int cuts[] = new int[len+1];

        if (s == null || s.length() == 0)
            return min;
        //初始化cuts里面的值为最坏情况的值
        for (int i=0; i<len; ++i){
            cuts[i] = len - i;
        }
        //dp过程
        for (int i=len-1; i>=0; --i){
            for (int j=i; j<len; ++j){
                if ((s.charAt(i) == s.charAt(j) && (j-i<2))
                        || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))
                {
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        return cuts[0]-1;
    }

    public static void main(String[] args) {
        String s ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(new Ch132().minCut2(s));
    }
}
