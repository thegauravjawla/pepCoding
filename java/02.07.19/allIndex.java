import java.util.*;

public class allIndex
{
    
    public static int[] allInd(int[] a, int x, int index, int count)
    {
        if(index == a.length)
        {
            int[] arr = new int[count];
            return arr;
        }
        if(a[index] == x)
        {
            count++;
            int[] arr = allInd(a, x, index + 1, count);
            count--;
            arr[count] = index;
            return arr;
        }
        else
        {
            return allInd(a, x, index + 1, count);
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

        int[] arr = allInd(a, x, 0, 0);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}