package Ch81_100;

import com.huihui.util.ArrayUtil;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length<m+n)
            return ;
        for(int i=m+n-1;i>=n;i--){
            nums1[i] = nums1[i-n];
        }
        int p1 = n;
        int p2 = 0;
        for(int i=0;i<nums1.length;i++){
            int num1 =p1==m+n?Integer.MAX_VALUE:nums1[p1];
            int num2 =p2==n?Integer.MAX_VALUE:nums2[p2];

            if(num1<num2){
                nums1[i] = num1;
                p1++;
            }
            else{
                nums1[i] =num2;
                p2++;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2= {3};
        new Ch88().merge(nums1,5,nums2,1);
        System.out.println(ArrayUtil.arrToString(nums1));
    }
}
