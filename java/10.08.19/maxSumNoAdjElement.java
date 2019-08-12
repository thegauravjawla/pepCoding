import java.util.*;
public class maxSumNoAdjElement
{
    static int maxSum(int[] a, int[][] t)
    {
        t[0][0] = 0; //exclude
        t[0][1] = a[0]; //include
        for(int i = 1; i < t.length; i++)
        {
            t[i][0] = Math.max(t[i-1][0], t[i-1][1]);
            t[i][1] = t[i-1][0] + a[i];
        }
        return Math.max(t[t.length-1][0], t[t.length-1][1]);
    }
    public static void main(String[] args) 
    {
        int[] a = {5, 6, 10, 100, 10, 5};
        int[][] t = new int[a.length][2];
        int ans = maxSum(a, t);
        System.out.println(ans);
    }
}

//int[] a = {5, -1, -2, -1, 5} 
//output = 10;

//int[] a = {5, 6, 10, 100, 10, 5}
//output = 111;
