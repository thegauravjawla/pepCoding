import java.util.*;
public class minArrayPathDP
{
    static int minStep(int[] a)
    {
        int[] t = new int[a.length];
        t[a.length - 1] = 0;
        for(int i = a.length - 2; i >= 0; i--)
        {
            int min = t[i + 1];
            for(int j = i + 1; j <= i + a[i] && j < a.length; j++)
            {
                if(min > t[j])
                    min = t[j];
            }
            t[i] = min + 1;
        }
        return t[0];
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = scn.nextInt();
        int ans = minStep(a);
        System.out.println(ans);
    }
}
// input -> 15
//4 2 0 0 2 4 6 3 1 0 1 2 3 1 1
//output -> 4