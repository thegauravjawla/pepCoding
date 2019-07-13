import java.util.*;
public class queenPlace
{
    private static boolean queenSafe(boolean[][] board, int row, int column)
    {
        int j = column;
        int i = row;
        while(j >= 0)
        {
            if(board[i][j] == true)
                return false;
            j--;
        }
        j = column;
        while(i >= 0)
        {
            if(board[i][j] == true)
                return false;
            i--;
        }
        i = row;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j] == true)
                return false;
            i--;j--;
        }
        i = row;
        j = column;
        while(i >= 0 && j < board[0].length)
        {
            if(board[i][j] == true)
                return false;
            i--;j++;
        }
        return true;
    }
    public static void placement(boolean[][] board, int queenNo, int row, int column, String ans)
    {
        if(queenNo == board.length)
        {
            System.out.println(ans);
            return;
        }
        for(int i = row; i < board.length; i++)
        {
            for(int j = (i == row? column+1:0); j < board[0].length; j++)
            {
                if(queenSafe(board, i, j) == true)
                {
                    board[i][j] = true;
                    placement(board, queenNo+1, i, j ,ans+"["+(i)+", "+(j)+"]");
                    board[i][j] = false;
                }
            }
        }
        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        placement(board, 0, 0, -1, "");
    }
}