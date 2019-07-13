import java.util.*;
public class nQueen
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
    static int c = 0;
    public static void placement(boolean[][] board, int row, int column, int knightPlaced, String ans)
    {
        if(row == board.length && column == 0)
        {
            if(knightPlaced == board.length)
            {
                System.out.println(++c + ans);
                return;
            }
            return;
        }
        else if(column < board[0].length - 1)
        {
            placement(board, row, column + 1, knightPlaced, ans);   //not placed
            if(queenSafe(board, row, column))
            {
                board[row][column] = true;
                placement(board, row, column + 1, knightPlaced + 1, ans+"["+(row)+", "+(column)+"]");   //placed
                board[row][column] = false;
            }
        }
        else if(column == board[0].length - 1)
        {
            placement(board, row + 1, 0, knightPlaced, ans);    //not placed
            if(queenSafe(board, row, column))
            {
                board[row][column] = true;
                placement(board, row + 1, 0, knightPlaced + 1, ans + "["+(row)+", "+(column)+"]");    //placed
                board[row][column] = false;
            }
        }
        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        placement(board, 0, 0, 0, "");
    }
}