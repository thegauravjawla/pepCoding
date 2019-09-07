import java.util.*;
public class Partition01{
    static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void partition(int[] a)
    {
        int oneStart = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == 0)
            {
                swap(a, oneStart, i);
                oneStart++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }

        partition(a);

        for(int i = 0; i < n; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}