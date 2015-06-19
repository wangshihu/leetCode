package Ch01;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length==0)
            return "";
        if(strs.length==1){
            return strs[0];
        }
        char[][] arr = new char[strs.length][];
        int maxIndex = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i]!=null){
                arr[i] = strs[i].toCharArray();
                if(maxIndex>arr[i].length){
                    maxIndex=arr[i].length;
                }
            }else{
                return null;
            }
        }
        for(int j=0;j<maxIndex;j++ ){
            char c = arr[0][j];
            for(int i=1;i<arr.length;i++){
                if(arr[i][j]!=c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abcd","ab","",null};
        System.out.println(new Ch14().longestCommonPrefix(strs));
    }
}
