package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch11 {
    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int ret = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            ret = Math.max(ret, area);

            if (height[i] <= height[j]) i++;
            else
                j--;
        }

        return ret;
    }
}
