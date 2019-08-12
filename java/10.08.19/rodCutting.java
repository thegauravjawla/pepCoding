import java.util.*;
public class rodCutting
{
    static int maxCost(int[] a, int[] t)
    {
        t[0] = 0;
        for(int i = 1; i < t.length; i++)
        {
            t[i] = a[i];
            int p = 0;
            int q = i;
            int max = -1;
            while(p <= q)
            {
                if(max < t[p]+t[q])
                {
                    max = t[p]+t[q];
                }
                p++;q--;
            }
            t[i] = max;
        }
        return t[t.length-1];
    }
    public static void main(String[] args) 
    {
        int[] a = {0, 3, 5, 6, 15, 10, 25, 12, 24};
        int[] t = new int[a.length];
        int ans = maxCost(a, t);
        System.out.println(ans);
    }
}