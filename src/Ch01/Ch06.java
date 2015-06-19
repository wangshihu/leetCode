package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch06 {
    public String convert(String s, int numRows) {
        if(s==null){
            return null;
        }
        char[][] list = new char[numRows][s.length()];
        char[] arr = s.toCharArray();
        int row = 0;
        int col = 0;
        boolean direction =true;//向下，false斜上
        for(int i=0;i<arr.length;i++){
            list[row][col] = arr[i];

            if(direction){
                row++;
                if(row==numRows){
                    row-=2;
                    col++;
                    if(row<0){
                        row=0;
                    }else{
                        direction = !direction;
                    }
                }
            }else{
                if(numRows<=2){//当numrows小于2的时候 不用做斜边处理，是竖线遍历。
                    row++;
                    if(row==numRows){
                        row=0;
                        col++;
                    }
                }else{//斜边处理
                    row--;
                    col++;
                    if(row==0){
                        direction = !direction;
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.length;i++){
            for(int j=0;j<list[i].length;j++){
                if(list[i][j]!='\0'){
                    sb.append(list[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDE";
        System.out.println(new Ch06().convert(s,2));
    }
}
