package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch12_13 {
    public String intToRoman(int num) {
        String[][] arr ={
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        int[] iArr = new int[4];
        for(int i=0;num!=0;i++,num/=10){
            iArr[i]=num%10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=3;i>=0;i--){
            sb.append(arr[i][iArr[i]]);
        }
        return sb.toString();
    }
    public int romanToInt(String s) {
        String[][] arr ={
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        if(s==null||s.equals("")){
            return 0;
        }
        int[] iArr = new int[4];
        for(int i=arr.length-1;i>=0;i--){
            for(int j=arr[i].length-1;j>0;j--){
                if(s.startsWith(arr[i][j])){
                    s = s.substring(arr[i][j].length());

                    iArr[i] = j;
                }
            }
        }
        int result = 0;
        int factor = 1;
        for(int i=0;i<iArr.length;i++,factor *=10){
            result+=iArr[i]*factor;
        }
        return result;
    }
}
