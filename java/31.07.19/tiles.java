import java.util.*;
public class tiles
{
    static int getPatternCount(int[] t, int m, int n)
    {
        t[0] = 1;
        t[1] = 1;
        for(int i = 2; i < n+1; i++)
        {
            t[i] = t[i-1];
            if(n-m>=0)
            {
                t[i] += t[i-m];
            }
        }
        return t[n];
    }
    public static void main(String[] args) 
    {
        int m = 2;
        int n = 10;
        if(m>n)
        {
            int temp = m;
            m = n;
            n = temp;
        }
        int[] t = new int[n+1];
        int ans = getPatternCount(t, m, n);
        System.out.println(ans);
    } 
}