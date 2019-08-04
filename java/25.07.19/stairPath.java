import java.util.*;
public class stairPath
{
    static int getPath(int n, int[] memo)
    {
        if(n == 0)  return 1;
        if(memo[n] != 0)
        {
            return memo[n];
        }
        int step1 = 0, step2 = 0, step3 = 0;
        if(n-1 >= 0)
            step1 = getPath(n-1, memo);
        if(n-2 >= 0)
            step2 = getPath(n-2, memo);
        if(n-3 >= 0)
            step3 = getPath(n-3, memo);
        int ans = step1 + step2 + step3;
        memo[n] = ans;
        return ans;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] memo = new int[n+1];
        int ans = getPath(n, memo);
        System.out.println(ans);
    }
}