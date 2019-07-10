import java.util.*;
public class reverseArray
{
    public static void reverse(int[] a, int start, int end)
    {
        if(start >= end)
            return;
        
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
        reverse(a, start+1, end-1);
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
        reverse(a, 0, a.length - 1);
        for(int i = 0; i < n; i++)
        {
            System.out.print(a[i] + " ");
        }        
    }
}

