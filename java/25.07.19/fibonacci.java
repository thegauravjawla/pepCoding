import java.util.*;
public class fibonacci
{
    static int fib(int n, int[] memo)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
        if(memo[n] != 0)
        {
            return memo[n];
        }
        int ans = fib(n-1, memo) + fib(n-2, memo);
        memo[n] = ans;
        return ans;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] memo = new int[n+1];
        int ans = fib(n, memo);
        System.out.println(ans);
    }
}