package Ch21_40;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hadoop on 2015/6/10 0010.
 */
public class Ch22 {
    public List<String> generateParenthesis(int n) {
        String zero = "()";
        Set<String> result = new HashSet<>();
        if(n<1)
            return new ArrayList<>(result);
        result.add(zero);
        Set<String>[] SetArr = new Set[n];
        SetArr[0]= result;
        for(int i=2;i<=n;i++){
            Set<String> tempSet = new HashSet<>();
            for(String str:result){
                tempSet.add("("+str+")");
                tempSet.add("()"+str);
                tempSet.add(str+"()");
            }
            for(int j=1;j<=i/2;j++){
                Set<String> setI = SetArr[i-j-1];
                Set<String> setJ = SetArr[j-1];
                for(String strI:setI){
                    for(String strJ:setJ){
                        tempSet.add(strI+strJ);
                        tempSet.add(strJ+strI);
                    }
                }
            }
            result = tempSet;
            SetArr[i-1] = result;
        }
        return new ArrayList<>(result);
    }

    public ArrayList<String> generateParenthesis2(int n) {
        ArrayList<String> rst = new ArrayList<String>();
        if(n <= 0) {
            return rst;
        }
        getPair(rst, "", n, n);
        return rst;
    }

    public void getPair( ArrayList<String> rst , String s, int left, int right) {
        if(left > right || left < 0 || right < 0) {
            return;
        }
        if(left == 0 && right == 0) {
            rst.add(s);
            return;
        }

        getPair(rst, s + "(", left - 1, right);
        getPair(rst, s + ")", left, right - 1);
    }

    public static  void test(int n){
        long beginTime = System.currentTimeMillis();
        List<String> result = new Ch22().generateParenthesis(n);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
        beginTime = System.currentTimeMillis();
        List<String> valid = new Ch22().generateParenthesis2(n);
        endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }

    public static void main(String[] args) {
        for(int i=1;i<15;i++){
            //List<String> result = new Ch22().generateParenthesis(i);
            List<String> valid = new Ch22().generateParenthesis2(i);
            System.out.println(valid.size());
//            for(String str:valid){
//                if(!result.contains(str))
//                    System.out.println(str);
//            }
        }
//        test(11);

    }
}
