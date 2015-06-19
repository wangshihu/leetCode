package Ch81_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch91 {
    public int numDecodings(String s) {
        if(s==null||s.equals(""))
            return 0;
        if(s.length()==1){
            if(s.charAt(0)>='1'&&s.charAt(0)<='9')
                return 1;
            else
                return 0;
        }
        List<Integer> nums = new ArrayList<>();
        char[] arr = s.toCharArray();
        int num = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '1'||arr[i]=='2'){//11-12,21-22 ������Ҫ��λ
                num++;
            }else if(arr[i]>='3'&&arr[i]<='6'){//13-16,23-26��Ҫ��λ
                if(i>0&& (arr[i-1]=='1'||arr[i-1]=='2')){
                    num++;
                }
                if(num>max)
                    max= num;
                nums.add(num);
                num=0;
            }else if((arr[i]>='7'&&arr[i]<='9') ){
                if(i>0&&arr[i-1]=='1')//17-19
                    num ++;
                if(num>max)
                    max= num;
                nums.add(num);
                num=0;
            }else if((arr[i]=='0'&&i>0&& (arr[i-1]=='1'||arr[i-1]=='2'))){//10,20��Ҫ��һλ
                num--;//��������numҪ-1
                if(num>max)
                    max= num;
                nums.add(num);
                num=0;
            }else{
                return 0;
            }
        }
        nums.add(num);
        if(num>max)
            max =num;
        if(max==0)//�����������
            return 1;

        //������쳲���������
        int[] fArr = new int[max+1];
        fArr[0] =1;
        fArr[1] =1;
        for(int i=2;i<fArr.length;i++){
            fArr[i] = fArr[i-1]+fArr[i-2];
        }
        int result = 1;
        for(Integer addNum:nums){
            result*=fArr[addNum];
        }
        return result;
    }

    public static void main(String[] args) {
        String s="17";
        System.out.println(new Ch91().numDecodings(s));
    }
}
