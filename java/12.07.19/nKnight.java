import java.util.*;
public class nKnight
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
            if(knightSafe(board, row, column))
            {
                board[row][column] = true;
                placement(board, row, column + 1, knightPlaced + 1, ans+"["+(row)+", "+(column)+"]");   //placed
                board[row][column] = false;
            }
        }
        else if(column == board[0].length - 1)
        {
            placement(board, row + 1, 0, knightPlaced, ans);    //not placed
            if(knightSafe(board, row, column))
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