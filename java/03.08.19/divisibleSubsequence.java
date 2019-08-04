import java.util.*;
public class divisibleSubsequence
{
    static int tds(String s, int[][] t, int k)
    {
        char ch = s.charAt(0);
        int n = (ch-48);
        t[0][0] = 1;
        t[0][n%k] = 1;

        for(int i = 0; i < s.length()-1; i++)
        {
            ch = s.charAt(i+1);
            n = (ch-48);
            for(int j = 0; j < t[0].length; j++)
            {
                t[i+1][j] += t[i][j];
                t[i+1][(j*10+n)%k] += t[i][j];
            }
        }
        return t[s.length()-1][0];
    }
    public static void main(String[] args) 
    {
        String s = "231568";
        int k = 6;
        int[][] t = new int[s.length()][k];
        int ans = tds(s, t, k);
        System.out.println(ans);
    }
}