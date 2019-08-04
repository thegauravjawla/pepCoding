import java.util.*;
public class arrayPathDP
{
    static int getPath(int[] a)
    {
        //tabulation DP
        int[] t = new int[a.length];    //t[i] ->path from i to end of array

        //filling the array t from end to start
        t[a.length - 1] = 1;
        for(int i = a.length - 2; i >= 0; i--)
        {
            for(int j = i + 1; j <= i + a[i] && j < a.length; j++)
            {
                t[i] += t[j];
            }
        }
        //////////////////////////////////////

        //now the total ans is stored in t[0]
        return t[0];
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = scn.nextInt();
        int ans = getPath(a);
        System.out.println(ans);
    }
}
// input -> 15
//4 2 0 0 2 4 6 3 1 0 1 2 3 1 1
//output -> 25