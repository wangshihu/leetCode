package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch04 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int aMinIndex = 0;
        int aMaxIndex = A.length - 1;
        int bMinIndex = 0;
        int bMaxIndex = B.length - 1;

        while (aMaxIndex - aMinIndex + 1 + (bMaxIndex - bMinIndex + 1) > 2) {

            boolean minInA = true;
            boolean maxInA = true;

            // drop the minimum one
            if (aMaxIndex >= aMinIndex && bMaxIndex >= bMinIndex) {
                minInA = A[aMinIndex] < B[bMinIndex];
            } else if ( bMaxIndex >= bMinIndex ) {
                minInA = false;
            }

            int useless = minInA?aMinIndex++:bMinIndex++;

            // drop the maximum one
            if (aMaxIndex >= aMinIndex && bMaxIndex >= bMinIndex) {
                maxInA = A[aMaxIndex] > B[bMaxIndex];
            } else if ( bMaxIndex >= bMinIndex ) {
                maxInA = false;
            }

            useless = maxInA?aMaxIndex--:bMaxIndex--;
        }

        if (aMaxIndex == aMinIndex && bMaxIndex == bMinIndex) {
            return (A[aMaxIndex] + B[bMaxIndex]) * 1.0 / 2;
        } else if (aMaxIndex == aMinIndex){
            return A[aMaxIndex];
        } else if (bMaxIndex == bMinIndex) {
            return B[bMaxIndex];
        } else if (aMaxIndex - aMinIndex == 1) {
            return (A[aMinIndex] + A[aMaxIndex]) * 1.0 / 2;
        } else if (bMaxIndex - bMinIndex == 1) {
            return (B[bMinIndex] + B[bMaxIndex]) * 1.0 / 2;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] nums1={5};
        int[] nums2={1,2,3,4};
        System.out.println(new Ch04().findMedianSortedArrays(nums1, nums2));
    }
}
