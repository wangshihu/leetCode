package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch05 {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }else if(s.length()<2){
            return s;
        }
        char[] arr = s.toCharArray();
        int ri =0;
        int rj =1;
        int maxLength =2;
        for(int i=0;i<arr.length-1;i++){
            int tempLength1 = 0;
            int tempLength2 = 0;
            int k1=0,l1=0;
            int k2=0,l2=0;
            if(arr[i]==arr[i+1]){
                tempLength1 = 2;
                k1=i;l1=i+1;
                while(k1-1>=0&&l1+1<arr.length&&arr[k1-1]==arr[l1+1]){
                    tempLength1+=2;
                    k1--;l1++;
                }
            }
            if(i>0&&arr[i-1]==arr[i+1]){
                tempLength2 = 3;
                k2=i-1;l2=i+1;
                while(k2-1>=0&&l2+1<arr.length&&arr[k2-1]==arr[l2+1]){
                    tempLength2+=2;
                    k2--;l2++;
                }
            }
            if(tempLength1>=maxLength){
                maxLength=tempLength1;
                ri=k1;
                rj=l1;
            }
            if(tempLength2>=maxLength){
                maxLength =tempLength2;
                ri=k2;
                rj=l2;
            }
        }
        System.out.println(ri+" "+(rj+1));
        return s.substring(ri,rj+1);
    }

    public static void main(String[] args) {
        String s="iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz";
        System.out.println(new Ch05().longestPalindrome(s));
    }
}
