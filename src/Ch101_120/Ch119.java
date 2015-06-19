package Ch101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex<0)
            return result;
        result.add(1);
        if(rowIndex==0)
            return result;
        for(int i=1;i<=rowIndex;i++){
            result.add(doCn(rowIndex,i));
        }

        return result;
    }
    public int doCn(int n,int m){
        if(m>n/2){
            return doCn(n,n-m);
        }
        double result = 1;
        for(int i=1;i<=m;i++){
            result = result*(n-i+1)/i;
        }
       return (int)result;
    }

    public ArrayList<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        rowIndex += 1;
        if (rowIndex == 0) {
            return rst;
        }

        rst.add(1);
        for (int i = 1; i < rowIndex; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
            for (int j = 0; j < i + 1; j++) {
                tmp.add(-1);
            }
            tmp.set(0, rst.get(0));
            tmp.set(i, rst.get(i - 1));
            for (int j = 1; j < i; j++) {
                tmp.set(j, rst.get(j - 1) + rst.get(j));
            }
            rst = tmp;
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new Ch119().getRow(4));
    }
}
