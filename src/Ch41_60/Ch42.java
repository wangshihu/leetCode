package Ch41_60;

/**
 * Created by hadoop on 2015/6/10 0010.
 */
public class Ch42 {
    public int trap(int[] height) {
        int result = 0;
        if(height==null||height.length<3)
            return 0;
        for(int i=0;i<height.length-1;){
            if(height[i]==0){
                i++;
                continue;
            }
            int left = height[i];
            int j=i+1;
            int closeIndex = j;//j的最近点;
            while(j<height.length){
                if(height[j]>=left)
                    break;
                else{
                    closeIndex = (height[i]-height[j]<=height[i]-height[closeIndex])?j:closeIndex;
                }
                j++;
            }
            if(j==height.length)
                j=closeIndex;
            if(j-i>1){
                int min = Math.min(height[j],left);
                for(int k=i+1;k<j;k++){
                    result +=min-height[k];
                }
                i=j;
            }else{
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height={4,2,3};
        System.out.println(new Ch42().trap(height));
    }
}
