package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch09 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int i=0;
        int[] arr = new int[10];
        while(x!=0){
            int current = x%10;
            arr[i] = current;
            i++;
            x=x/10;
        }
        int k=0,l=i-1;
        for(;k<l;k++,l--){
            if(arr[k]!=arr[l]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Ch09().isPalindrome(0));
    }
}
