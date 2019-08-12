import java.util.*;
public class optimalBST
{
    static int minCost(int[] a, int[] f, int[][] t, int[] fSum)
    {
        for(int k = 0; k < a.length; k++)
        {
            for(int i = 0; i < a.length-k; i++)
            {
                int j = i+k;
                if(i == j)
                {
                    t[i][j] = f[i];
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    for(int l = 0; l < k+1; l++)
                    {
                        int left = l==0?0:t[i][i+l-1];
                        int down = l==k?0:t[i+l+1][j];
                        if(min>left+down)    min = left+down;
                    }
                        // for(int ii = 0; ii < l; ii++)
                        // {
                        //     fq+=f[ii];
                        // }
                    t[i][j] = min + fSum[j] - (i>1?fSum[i-1]:0);
                }
            }
        }
        return t[0][a.length-1];
    }
    public static void main(String[] args) 
    {
        int[] a = {10, 20, 30, 40, 50, 60, 70};
        int[] f = {2, 1, 4, 1, 1, 3, 5};
        int[] fSum = new int[f.length];
        fSum[0] = f[0];
        for(int i = 1; i < f.length; i++)   fSum[i] = f[i] + fSum[i-1];
        int[][] t = new int[a.length][a.length];
        int ans = minCost(a, f, t, fSum);
        System.out.println(ans);
    }
}