import java.util.*;
public class max
{
    public static void main(String[] argv)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = scn.nextInt();
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(max < arr[i])
                max = arr[i];
        }
        System.out.println(max);
    }
}