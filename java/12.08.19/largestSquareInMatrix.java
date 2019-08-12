import java.util.*;
public class largestSquareInMatrix
{
    static int largestSquare(int[][] t)
    {
        int max = 0;
        for(int i = t.length-2; i>=0; i--)
        {
            for(int j = t.length-2; j>=0; j--)
            {
                if(t[i][j] != 0)
                {
                    int min = Math.min(t[i+1][j], t[i][j+1]);
                    min = Math.min(t[i+1][j+1], min);
                    t[i][j] = min+1;
                    if(t[i][j] > max)   max = t[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) 
    {
        int[][] m ={{1, 0, 0, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 1, 0},
                    {0, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 1, 0},
                    {1, 1, 1, 1, 1, 1, 1}};
        int[][] t = m;
        int ans = largestSquare(t);
        System.out.println(ans);
    }
}