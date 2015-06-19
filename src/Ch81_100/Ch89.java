package Ch81_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int factor = 1;
        for (int i = 0; i < n; i++) {
            List<Integer> tempList = new ArrayList<>(result);
            for (int j=result.size()-1;j>=0;j--) {
                Integer x= result.get(j)+factor;
                tempList.add(x);
            }
            result = tempList;
            factor*=2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Ch89().grayCode(3));
    }
}
