package Ch101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows<=0)
            return result;
        List<Integer> zeorList = new ArrayList<>();
        zeorList.add(1);
        result.add(zeorList);
        for(int i=1;i<numRows;i++){
            List<Integer> tempList = new ArrayList<>();
            List<Integer> preList = result.get(i - 1);
            tempList.add(1);
            for(int j=1;j<preList.size();j++){
                tempList.add(preList.get(j-1)+preList.get(j));
            }
            tempList.add(1);
            result.add(tempList);
        }
        return result;
    }
}
