import java.util.*;
public class palindrome
{
    public static boolean judge(int[] a, int start, int end)
    {
        if(start >= end)
            return true;

        boolean judgeSmall = judge(a, start + 1, end - 1);
        if(judgeSmall && a[start] == a[end])
            return true;
        else
            return false;
    }
    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }

        boolean ans = judge(a, 0, a.length - 1);
        System.out.println(ans);
    }
}

