import java.util.*;
public class arrayPath
{
    static int getPath(int[] a, int index, int[] memo)
    {
        if(index == a.length - 1)
        {
            return 1;
        }
        if(memo[index] != 0)
        {
            return memo[index];
        }
        int ans = 0;
        for(int i = 1; i <= a[index]; i++)
        {
            if(index + i <= a.length - 1)
                ans += getPath(a, index + i, memo);
        }
        memo[index] = ans;
        return ans;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = scn.nextInt();
        int[] memo = new int[n+1];
        int ans = getPath(a, 0, memo);
        System.out.println(ans);
    }
}
// input -> 15
//4 2 0 0 2 4 6 3 1 0 1 2 3 1 1
//output -> 25