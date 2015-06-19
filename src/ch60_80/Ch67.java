package ch60_80;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch67 {
    public String addBinary(String a, String b) {
        if(a==null||b==null)
            return null;
        if(a.equals("")||b.equals(""))
            return "";

        int maxLength = Math.max(a.length(),b.length());

        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        char[] arr = new char[maxLength+1];
        char carry = '0';
        int pa = a.length()-1;
        int pb = b.length()-1;
        for(int i=maxLength;i>0;i--,pa--,pb--){
            char ac = pa>=0?aArr[pa]:'0';
            char bc = pb>=0?bArr[pb]:'0';
            char result = '0';

            if((ac=='1'&&bc=='0') || (ac=='0'&&bc=='1' )){
                if(carry=='0')
                    result = '1';
                else
                    carry='1';
            }else if(ac=='1'&&bc=='1'){
                result = carry;
                carry = '1';
            }else{
                result = carry;
                carry='0';
            }
            arr[i] =result;
        }
        if(carry=='1'&&(a.charAt(0)!='0'&&b.charAt(0)!='0')){
            arr[0] = '1';
            return new String(arr);
        }
        return  new String(arr).substring(1);

    }

    public static void main(String[] args) {
        String a ="1010";
        String b ="1011";
        System.out.println(new Ch67().addBinary(a,b));
    }
}
