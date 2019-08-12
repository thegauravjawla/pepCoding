import java.util.*;
public class matrixMultiplication
{
    static int minMultiplications(int[] d, int[][] t)
    {
        for(int k = 0; k < t.length; k++)
        {
            for(int i = 0; i < t.length-k; i++)
            {
                int j = i+k;
                if(k==0||k==1)
                {
                    t[i][j]=0;
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    for(int l = 1; l < k; l++)
                    {
                        int left = t[i][j-k+l];
                        int down = t[i+l][j];
                        int ans = left+down+d[l]*d[0]*d[k];
                        if(min > ans) min = ans;
                    }
                    t[i][j] = min;
                }
            }
        }
        return t[0][t.length-1];
    }
    public static void main(String[] args) 
    {
        int[] d = {10, 20, 30, 40, 50, 60};
        int[][] t = new int[d.length+1][d.length+1];
        int ans = minMultiplications(d, t);
        System.out.println(ans);
    }
}