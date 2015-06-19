package Ch201_220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/12 0012.
 */
public class Ch219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer num = map.get(nums[i]);
            if(num==null)
                map.put(nums[i],i);
            else  {
                if(i-num<=k)
                    return true;
                else
                    map.put(nums[i],i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k= 1;
        System.out.println(new Ch219().containsNearbyDuplicate(nums,k));
    }

}
