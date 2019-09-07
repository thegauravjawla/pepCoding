import java.util.*;
public class partitionHighLow{
    static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //not correct
    static void partition(int[] a, int high, int low)
    {
        int oneStart = 0;
        int twoStart = a.length;
        for(int i = 0; i < twoStart; )
        {
            if(a[i] > low && a[i] < high)
            {
                i++;
            }
            else if(a[i] < low)
            {
                swap(a, oneStart, i);
                i++;
                oneStart++;
            }
            else if(a[i] > high)
            {
                swap(a, twoStart-1, i);
                twoStart--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int low = scn.nextInt();
        int high = scn.nextInt();
        for(int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }

        partition(a, high, low);

        for(int i = 0; i < n; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}