import java.util.*;
public class function
{
    public static void reverse(int[] a)
    {
        int l = 0;
        int r = a.length - 1;

        int temp;
        while(l < r)
        {
            temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void display(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //main function here
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }
        reverse(a);
        display(a);
    }
}