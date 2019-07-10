import java.util.*;
public class barGraph
{
    public static void main(String[] argv)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }
        int max = a[0];
        for (int i = 1; i < n; i++)
        {
            if (a[i] > max)
            {
                max = a[i];
            }
        }
        int maxx = max;
        for(int i = 0; i < max; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(a[j] >= maxx)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
            maxx--;
        }
    }
}