import java.util.*;

public class maxArray
{
    public static int max(int[] a, int index)
    {
        if(index == a.length - 1)
            return a[index];
        int n = a[index];
        int maxLess = max(a, index + 1);
        if(n > maxLess)
        {
            return n;
        }
        else
        {
            return maxLess;
        }
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

        int maxNum = max(a, 0);
        System.out.println(maxNum);
    }
}