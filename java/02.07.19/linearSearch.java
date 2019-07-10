import java.util.*;

public class linearSearch
{
    public static boolean found(int[] a, int x, int index)
    {
        if(index == a.length)
            return false;

        if(a[index] == x || found(a, x, index + 1))
        {
            return true;
        }
        else
        {
            return false;
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
        System.out.println(found(a, x, 0));
    }
}