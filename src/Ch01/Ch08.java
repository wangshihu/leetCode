package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch08 {

    public int myAtoi(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        int b = 1;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            b = -1;
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
            b = 1;
        }

        char[] charArr = str.toCharArray();
        long result = 0;
        long factor = 1;
        int i = 0;
        for (; i < charArr.length; i++) {
            if (charArr[i] < '0' || charArr[i] > '9') {
                break;
            }
        }
        if(i>10){
            if(b==1){
                return Integer.MAX_VALUE;
            }
            if(b==-1){
                return Integer.MIN_VALUE;
            }
        }
        for (i-=1; i >= 0; i--) {
            result += ((int) charArr[i] - 48) * factor;
            factor *= 10;
        }
        if(result>Integer.MAX_VALUE&&b==1){
            return Integer.MAX_VALUE;
        }else if(result>Integer.MAX_VALUE &&b==-1){
            return Integer.MIN_VALUE;
        }
        return (int) result * b;
    }

    public static void main(String[] args) {
        System.out.println(new Ch08().myAtoi("9223372036854775809"));
    }
}
