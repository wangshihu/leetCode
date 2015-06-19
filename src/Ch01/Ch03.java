package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch03 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return -1;
        }
        char[] arr = s.toCharArray();
        if(s.length()<1){
            return s.length();
        }
        int maxLength = 1;
        int tempLength =1;
        for(int i=0,j=1;j<arr.length;j++){
            boolean flag = true;
            int temp =0;
            for(int k=i;k<j;k++){
                if(arr[k]==arr[j]){
                    flag = false;
                    i=k+1;
                    break;
                }
                temp++;
            }
            if(flag){
                tempLength++;
            }else{
                tempLength-=temp;
            }
            if(tempLength>maxLength){
                maxLength = tempLength;
            }
        }
        return maxLength;
    }
}
