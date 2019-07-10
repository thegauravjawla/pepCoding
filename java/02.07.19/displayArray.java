import java.util.*;
public class displayArray
{
    public static void display(int[] a, int index)
    {
        if(index == a.length)
            return;
        System.out.print(a[index] + " "); //forward
        display(a, index + 1);
        System.out.print(a[index] + " "); //reverse
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

        display(a, 0);
    }
}