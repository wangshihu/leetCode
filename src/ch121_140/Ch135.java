package ch121_140;

import java.util.Arrays;

/**
 * Created by hadoop on 2015/6/7 0007.
 */
public class Ch135 {

    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0)
            return 0;
        int result =0;
        int[] candyArr = new int[ratings.length];
        Arrays.fill(candyArr,1);//初始化所有小孩的糖果
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candyArr[i]=candyArr[i-1]+1;
            }
        }
        for(int i=ratings.length-1;i>0;i--){
            result+=candyArr[i];
            if(ratings[i-1]>ratings[i]&&candyArr[i-1]<=candyArr[i])
                candyArr[i-1]=candyArr[i]+1;
        }
        result+=candyArr[0];

        return result;
    }

    public static void main(String[] ags){
        int[] arr = {6,10,13,5,8,3,2,11};
        System.out.println(new Ch135().candy(arr));
    }
}
