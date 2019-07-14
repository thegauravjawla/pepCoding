import java.util.*;

public class sudoku
{
    static boolean isValid(int[][] q, int i, int j, int option)
    {
        for(int ii = 0; ii < q.length; ii++)
        {
            if(q[ii][j] == option)
                return false;
        }
        for(int jj = 0; jj < q[0].length; jj++)
        {
            if(q[i][jj] == option)
                return false;
        }
        for(int ii = 0; ii < 3; ii++)
        {
            for(int jj = 0; jj < 3; jj++)
            {
                int row = (i/3)*3 + ii;
                int column = (j/3)*3 + jj;
                if(q[row][column] == option)
                    return false;
            }
        }
        return true;
    }
    static int count = 0;
    static void solve(int[][]q, int i, int j)
    {
        if(i == q.length && j == 0)
        {
            ++count;
            System.out.println("-------" + count + "-------");
            for(int ii = 0; ii < q.length; ii++)
            {
                for(int jj = 0; jj < q[0].length; jj++)
                {
                    System.out.print(q[ii][jj] + " ");
                }
                System.out.println();
            }
            System.out.println("-------" + count + "-------");
            return;
        }
        else if(j == q[0].length - 1)
        {
            if(q[i][j] != 0)
            {
                solve(q, i+1, 0);
            }
            else
            {
                for(int option = 1; option <= 9; option++)
                {
                    if(isValid(q, i, j, option))
                    {
                        q[i][j] = option;
                        solve(q, i+1, 0);
                        q[i][j] = 0;
                    }
                }
            }
        }
        else
        {
            if(q[i][j] != 0)
            {
                solve(q, i, j+1);
            }
            else
            {
                for(int option = 1; option <= 9; option++)
                {
                    if(isValid(q, i, j, option))
                    {
                        q[i][j] = option;
                        solve(q, i, j+1);
                        q[i][j] = 0;
                    }
                }
            }
            return;
        }
    }
    public static void main(String[] args) 
    {
        int[][] q = {{3, 0, 6, 5, 0, 8, 4, 0, 0},  
                      {5, 2, 0, 0, 0, 0, 0, 0, 0},  
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solve(q, 0, 0);
    }
}