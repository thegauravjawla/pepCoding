import java.util.*;
public class goldMine
{

    static int maxGold(int[][] mine, int[][] t)
    {
        for(int j = mine[0].length - 1; j >= 0; j--)
        {
            for(int i = mine.length - 1; i >= 0; i--)
            {
                if(j == mine[0].length - 1)
                {
                    t[i][j] = mine[i][j];
                }
                else if(i == 0)
                {
                    t[i][j] = Math.max(t[i][j+1], t[i+1][j+1]) + mine[i][j];
                }
                else if(i == mine.length - 1)
                {
                    t[i][j] = Math.max(t[i][j+1], t[i-1][j+1])+ mine[i][j];
                }
                else
                {
                    int temp = Math.max(t[i][j+1], t[i-1][j+1]);
                    t[i][j] = Math.max(temp, t[i+1][j+1])+ mine[i][j];
                }
            }
        }
        int max = t[0][0];
        for(int i = 1; i < mine.length; i++)
        {
            if(max < t[i][0])
            {
                max = t[i][0];
            }
        }
        return max;
    }
    public static void main(String[] args) 
    {
        int[][] mine = {
            {1, 5, 1, 0, 3},
            {1, 4, 0, 2, 3},
            {4, 0, 1, 3, 2},
            {2, 4, 0, 4, 1},
            {1, 2, 3, 2, 0},
        };
        int[][] t = new int[mine.length][mine[0].length];
        int ans = maxGold(mine, t);
        System.out.println(ans);
    }
}