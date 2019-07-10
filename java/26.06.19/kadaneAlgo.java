import java.util.*;
public class kadaneAlgo
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }

        int l = 0;
        int r = 1;
        int lf = 0;
        int rf = 0;
        int sum = a[0];
        int sumf = a[0];

        //keep the left same if the sum is +ve; else update l = r;

        for (; r < n; r++)
        {
            if(sum > 0)
            {
                sum += a[r];
            }
            else
            {
                l = r;
                sum = a[r];
            }
            if(sum > sumf)
            {
                sumf = sum;
                lf = l;
                rf = r;
            }
        }
        for (int i = lf; i <= rf; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}