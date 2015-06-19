package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch201 {
    public int rangeBitwiseAnd(int m, int n) {
        int i=1;
        int max = 0xffffffff;
        for(;i<=n-m;i*=2){
            if(m==0)
                return 0;
            m &=(max-i);
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new Ch201().rangeBitwiseAnd(0,Integer.MAX_VALUE));
    }
}
