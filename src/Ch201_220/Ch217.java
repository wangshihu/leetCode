package Ch201_220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/12 0012.
 */
public class Ch217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer num = map.get(nums[i]);
            if(num==null)
                map.put(nums[i],1);
            else if(num==1)
                return true;
        }
        return false;
    }
}
