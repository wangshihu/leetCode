package ch121_140;


import com.huihui.util.ArrayUtil;


/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch130 {
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return ;
        }
        for(int j=0;j<board[0].length;j++){//上
            if(board[0][j]=='O')
                board[0][j]='T';
        }
        for(int i=1;i<board.length;i++){//右
            if(board[i][board[i].length-1]=='O')
                board[i][board[i].length-1]='T';
        }
        for(int j=board[board.length-1].length-1;j>=0;j--){//下
            if(board[board.length-1][j]=='O')
                board[board.length-1][j]='T';
        }
        for(int i=1;i<board.length-1;i++){//左
            if(board[i][0]=='O')
                board[i][0]='T';
        }
        for(int i=1;i<board.length-1;i++){//上左遍历
            for(int j=1;j<board[i].length-1;j++){
                setLive(board,i,j);
            }
        }
        for(int i=board.length-2;i>0;i--){//下右遍历
            for(int j=board[i].length-2;j>0;j--){
                setLive(board,i,j);
            }
        }
        for(int i=1;i<board.length-1;i++){//上右遍历
            for(int j=1;j<board[i].length-1;j++){
                setLive(board,i,j);
            }
        }
        for(int i=board.length-2;i>0;i--){//下左遍历
            for(int j=1;j<board[i].length-1;j++){
                setLive(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++){//还原
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='T')
                    board[i][j]='O';
            }
        }
    }

    public void setLive(char[][] board,int i,int j){
        if(board[i][j]=='O' && (board[i-1][j]=='T'||board[i][j-1]=='T'||board[i+1][j]=='T'||board[i][j+1]=='T')){
            board[i][j]='T';
            if(board[i+1][j]=='O')
                board[i+1][j]='T';
            if(board[i-1][j]=='O')
                board[i-1][j]='T';
            if(board[i][j+1]=='O')
                board[i][j+1]='T';
            if(board[i][j-1]=='O')
                board[i][j-1]='T';
        }
    }

    public void solve1(char[][] board) {
        if(board==null||board.length==0){
            return ;
        }
        for(int j=1;j<board[0].length-1;j++){//上
            if(board[0][j]=='O')
                live(board,0,j);
        }
        for(int i=1;i<board.length;i++){//右
            if(board[i][board[i].length-1]=='O')
                live(board,i,board[i].length-1);
        }
        for(int j=board[board.length-1].length-2;j>0;j--){//下
            if(board[board.length-1][j]=='O')
                live(board,board.length-1,j);
        }
        for(int i=1;i<board.length-1;i++){//左
            if(board[i][0]=='O')
                live(board,i,0);
        }

        for(int i=0;i<board.length;i++){//还原
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='T')
                    board[i][j]='O';
            }
        }
    }
    public void live(char[][] board,int i,int j){
        board[i][j] = 'T';
        boolean fr = (j==0&&j==board[0].length-1);//如果在左右2排
        boolean fl = (i==0&&i==board.length-1);//如果在上下2排
        if(i>0&&board[i-1][j]=='O'&&!fr)//上
            live(board,i-1,j);
        if(i<board.length-1&&board[i+1][j]=='O'&&!fr)//下
            live(board,i+1,j);
        if(j>0&&board[i][j-1]=='O'&&!fl)//左
            live(board, i, j-1);
        if(j<board[i].length-1&&board[i][j+1]=='O'&&!fl)//右
            live(board, i, j+1);
    }

    public static boolean check(char[][] board,String[] anwser){
        for(int i=0;i<anwser.length;i++){
            if(!anwser[i].equals(new String(board[i])))
                return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        //char[][] board={"XXXX".toCharArray(),"XOOO".toCharArray(),"XXOX".toCharArray(),"XOXX".toCharArray()};
        //String[] arr ={"XOXOXOOOXO","XOOXXXOOOX","OOOOOOOOXX","OOOOOOXOOX","OOXXOXXOOO","XOOXXXOXXO","XOXOOXXOXO","XXOXXOXOOX","OOOOXOXOXO","XXOXXXXOOO"};
        String[] arr = {"OXXXXOOXOXXXXXXOOXXO","OOOOOOXOXOXOOXXOOOXO","OXOXOXOXOOXXXOOOOOOX","XOOXXXXXOXOOOOXOXOXO","OXOOOOXOOOOXOOXOXXXO","OOOOOOOXOXXOOXXOOXOX","OOXXXXOXXXXOOOXOXOXX","XXXXOOXOXOOOOOOXXXOX","XOOOXXOOXOXXOOOXOOOO","XOOXOXOXOOXXXOOOOOXO","OOOXOOXOOOOOOXOXOOXX","OXOOXXXOXXXOOOXOXOOO","XXXOXXOXOXOXXOOOXOOO","OXXOXOOXXOXXOXXOXXOO","OXXOOXOOOXOXOOOOOOXX","OOXOOOXXOXXXXOXOXOXO","XOOOXOXOXOOOOXXOOOOO","XOOXXOOXXOOOXOOOXXXO","OXOXXOOOXXOOXXXOOXXO","OOXOXOOOOOOOOXOXOOXO"};
        String[] anwser ={"OXXXXOOXOXXXXXXOOXXO","OOOOOOXXXOXXXXXOOOXO","OXOXOXXXOOXXXOOOOOOX","XOOXXXXXOXOOOOXOXOXO","OXOOOOXOOOOXOOXOXXXO","OOOOOOOXOXXOOXXOOXXX","OOXXXXOXXXXOOOXOXXXX","XXXXXXXXXOOOOOOXXXOX","XOOOXXXXXOXXOOOXOOOO","XOOXXXXXOOXXXOOOOOXO","OOOXXXXOOOOOOXOXOOXX","OXOOXXXOXXXOOOXOXOOO","XXXOXXXXXXXXXOOOXOOO","OXXOXXXXXXXXOXXOXXOO","OXXOOXXXXXXXOOOOOOXX","OOXOOOXXXXXXXOXOXOXO","XOOOXOXXXOOOOXXOOOOO","XOOXXOOXXOOOXOOOXXXO","OXOXXOOOXXOOXXXOOXXO","OOXOXOOOOOOOOXOXOOXO"};
        char[][] board = ArrayUtil.switchStringArrToChar(arr);
        ArrayUtil.printCharArr(board);
        System.out.println();
        new Ch130().solve(board);
        ArrayUtil.printCharArr(board);

        System.out.println(check(board,anwser));
    }
}
