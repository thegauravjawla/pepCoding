import java.util.*;
public class longestBitonicSubsequence
{
    //here we have to calculate LIS forward, and LDS backwards and then ans = maxSum - 1
    public static void main(String[] args) 
    {
        int[] a = {10, 21, 9, 33, 22, 50, 41, 60, 80, 7};
        int[][] t = new int[a.length][2];
        int ans = sizeOfLBS(a, t);
        System.out.println(ans);
    }
}