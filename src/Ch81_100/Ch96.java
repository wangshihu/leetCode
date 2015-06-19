package Ch81_100;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch96 {
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            int num = 0;
            for(int j=0;j<i;j++){
                int left = arr[j];
                int right = arr[i-j-1];
                num +=left*right;
            }
            arr[i] = num;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(new Ch96().numTrees(10));
    }
}
