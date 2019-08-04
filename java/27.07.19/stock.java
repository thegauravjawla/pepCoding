import java.util.*;
public class stock
{

    static int getProfit(int[] n, int[][] t, int transactionCost)
    {
        t[0][0] = -n[0];
        t[0][1] = 0;
        for(int i = 1; i < n.length; i++)
        {
            t[i][0] = Math.max(t[i-1][0], t[i-1][1] - n[i]);
            t[i][1] = Math.max(t[i-1][0], t[i-1][0] + n[i] - transactionCost);
        }
        return t[n.length-1][1];
    }
    public static void main(String[] args) 
    {
        int[] n = {9, 1, 3, 10, 1, 4, 6, 9};
        int transactionCost = 2;
        int[][] t = new int[n.length][2];
        int ans = getProfit(n, t, transactionCost);
        System.out.println(ans);
    }
}