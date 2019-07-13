import java.util.*;
public class knightPlace
{
    private static boolean knightSafe(boolean[][] board, int row, int column)
    {
        if(row - 1 >= 0 && column - 2 >= 0 && board[row - 1][column - 2] == true)
        {
            return false;
        }
        else if(row - 1 >= 0 && column + 2 < board[0].length && board[row - 1][column + 2] == true)
        {
            return false;
        }
        else if(row - 2 >= 0 && column - 1 >= 0 && board[row - 2][column - 1] == true)
        {
            return false;
        }
        else if(row - 2 >= 0 && column + 1 < board[0].length && board[row - 2][column + 1] == true)
        {
            return false;
        }
        return true;
    }
    static int c = 0;
    public static void placement(boolean[][] board, int knightNo, int row, int column, String ans)
    {
        if(knightNo == board.length)
        {
            System.out.println(++c + ans);
            return;
        }
        for(int i = row; i < board.length; i++)
        {
            for(int j = (i == row? column+1:0); j < board[0].length; j++)
            {
                if(knightSafe(board, i, j) == true)
                {
                    board[i][j] = true;
                    placement(board, knightNo+1, i, j ,ans+"["+(i)+", "+(j)+"]");
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