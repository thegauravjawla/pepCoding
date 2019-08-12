import java.util.*;
public class eggDrop
{
    static int minAttempt(int e, int f, int[][] t)
    {
        for(int j = 0; j < t[0].length; j++)
        {
            t[1][j] = j;
        }
        for(int i = 2; i <= e; i++)
        {
            for(int j = 0; j <= f; j++)
            {
                if(j==0)
                {
                    t[i][j] = 0;
                }
                else
                {
                    int min = j;
                    for(int k = 1; k <= j; k++)
                    {
                        int sum = Math.max(t[i-1][k-1], t[i][j-k]); //broken, not broken
                        if(sum < min)   min = sum;
                    }
                    t[i][j] = min+1;
                }
            }
        }
        return t[e][f];
    }
    public static void main(String[] args) 
    {
        int e = 2;
        int f = 10;
        int[][] t = new int[e+1][f+1];
        int ans = minAttempt(e, f, t);
        System.out.println(ans);
    }
}
//2, 10 -> 4
//2, 100 -> 14