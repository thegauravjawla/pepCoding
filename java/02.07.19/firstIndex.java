import java.util.*;

public class firstIndex
{
    public static int firstInd(int[] a, int x, int index)
    {
        if(index == a.length)
            return -1;

        if(a[index] == x)
        {
            return index;
        }
        else
        {
            return firstInd(a, x, index + 1);
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
        int x = scn.nextInt();
        System.out.println(firstInd(a, x, 0));
    }
}