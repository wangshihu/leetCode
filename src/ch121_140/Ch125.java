package ch121_140;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch125 {
    public boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<j;){
            if(!isAlphanumeric(s.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i)==s.charAt(j)|| Math.abs( (int)(s.charAt(i)-s.charAt(j)))==32 ){
                i++;
                j--;
            }else{
                return false;
            }

        }
        return true;
    }

    public boolean isAlphanumeric(char c){
        if(Character.isAlphabetic(c)||(c>='0'&&c<='9'))
            return true;
        return false;
    }


    public static void main(String[] args) {

        String s= "1a2";
        System.out.println(new Ch125().isPalindrome(s));
    }
}
