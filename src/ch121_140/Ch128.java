package ch121_140;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, 0);
        }
        int maxlength = 1;
        for (int i : nums) {
            if (map.get(i) == 1)
                continue;
            int temp = i;
            int tempMaxLength = 1;
            while (map.containsKey(++i)) {
                tempMaxLength++;
                map.put(i, 1);
            }
            while (map.containsKey(--temp)) {
                tempMaxLength++;
                map.put(temp, 1);
            }
            maxlength = Math.max(maxlength, tempMaxLength);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 100, 4, 200, 1, 3, 2, -6, -5};
        System.out.println(new Ch128().longestConsecutive(nums));
    }
}
