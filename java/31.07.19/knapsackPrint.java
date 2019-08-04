import java.util.*;
public class knapsackPrint
{
    static void getMaxPrice(int[] wt, int[] price, int[][] t, int target)
    {
        for(int i = 0; i < wt.length; i++)
        {
            for(int j = 0; j < target+1; j++)
            {
                if(i==0&&j==0)
                {
                    t[i][j] = 0;
                }
                else if(j==0)
                {
                    t[i][j] = 0;
                }
                else if(i==0)
                {
                    if(j >= i)   t[i][j] = price[i];
                    else t[i][j] = 0;
                }
                else 
                {
                    int max = t[i-1][j];
                    if(j-wt[i]>=0 && t[i-1][j-wt[i]] + price[i]> max)
                    {
                        max = t[i-1][j-wt[i]] + price[i];
                    }
                    t[i][j] = max;
                }
            }
        }
    }

    static void printPath(int[][] t)
    {
        for(int i = t.length-1; i>=0; i--)
        {
            for(int j = target)
        }
    }
    public static void main(String[] args) 
    {
        int[] wt = {2, 5, 1, 3, 4};
        int[] price = {15, 14, 10, 45, 30};
        int target = 7;
        int[][] t = new int[wt.length][target+1];
        getMaxPrice(wt, price, t, target);
        printPath(t);
    }
}