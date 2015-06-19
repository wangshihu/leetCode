package ch60_80;

/**
 * Created by hadoop on 2015/6/1 0001.
 */
public class Ch79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] isUse = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(word.length()==1)//单字符
                        return true;
                    isUse[i][j] = true;
                    boolean flag = findNext(board,isUse,i,j,1,word);
                    if(flag){//如果找到了就返回吧
                        return true;
                    }
                    isUse[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean findNext(char[][] board,boolean[][] isUse,int row,int col,int index,String word){
        if(index==word.length())
            return true;
        boolean flag1 = false;//上
        boolean flag2 = false;//下
        boolean flag3 = false;//左
        boolean flag4 = false;//右

        if(col>0&& !isUse[row][col-1]&&board[row][col-1]==word.charAt(index)){//上
            isUse[row][col-1]= true;
            flag1 = findNext(board, isUse, row, col-1, index+1, word);
            if(flag1)
                return true;
            isUse[row][col-1]= false;
        }
        if(col<board[row].length-1&& !isUse[row][col+1]&&board[row][col+1]==word.charAt(index)){//下
            isUse[row][col+1]= true;
            flag2 = findNext(board, isUse, row, col+1, index+1, word);
            if(flag2)
                return flag2;
            isUse[row][col+1]= false;
        }
        if(row>0&& !isUse[row-1][col]&&board[row-1][col]==word.charAt(index)){//左
            isUse[row-1][col]= true;
            flag3 = findNext(board, isUse, row-1, col, index+1, word);
            if(flag3)
                return flag3;
            isUse[row-1][col]= false;
        }
        if(row<board.length-1&& !isUse[row+1][col] && board[row+1][col]==word.charAt(index)){//右
            isUse[row+1][col]= true;
            flag4 = findNext(board, isUse, row+1, col, index+1, word);
            if(flag4)
                return true;
            isUse[row+1][col]= false;
        }
        return flag1||flag2||flag3||flag4;

    }

    public static void main(String[] args) {

        char[][] board = {"ABCE".toCharArray(),"SFCS".toCharArray(),"ADEE".toCharArray()};
//        System.out.println(new Ch79().exist(board,"ABCCED")+", true");
//        System.out.println(new Ch79().exist(board,"SEE")+", true");
//        System.out.println(new Ch79().exist(board,"ABCB")+", flase");

        char[][] board2={"ab".toCharArray(),"cd".toCharArray()};
        System.out.println(new Ch79().exist(board2,"abcd")+", flase");
        System.out.println(new Ch79().exist(board2,"acdb")+", true");
    }
}
