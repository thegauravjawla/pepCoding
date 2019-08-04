import java.util.*;
public class knapsackNoLimit
{
    static int getMaxPrice(int[] wt, int[] price, int[] t, int target)
    {
        t[0] = 0;
        for(int i = 1; i < target+1; i++)
        {
            t[i] = -1;
            for(int j = 0; j < wt.length; j++)
            {
                if(i-wt[j]>=0 && price[j] + t[i-wt[j]] > t[i])
                {
                    t[i] = price[j] + t[i-wt[j]];
                }
            }
        }
        return t[target];
    }
    public static void main(String[] args) 
    {
        int[] wt = {2, 5, 1, 3, 4};
        int[] price = {15, 14, 10, 45, 30};
        int target = 7;
        int[] t = new int[target+1];
        int ans = getMaxPrice(wt, price, t, target);
        System.out.println(ans);
    }
}