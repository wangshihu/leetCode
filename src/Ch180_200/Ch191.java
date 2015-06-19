package Ch180_200;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch191 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= (n - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = -2;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(new Ch191().hammingWeight(n));
    }
}
