import java.util.*;
public class lowestPalindromeSubsequence
{
    static int lps(int[][] t, String p)
    {
        for(int k = 0; k < p.length(); k++)
        {
            for(int i = 0; i < p.length()-k; i++)
            {
                int j = i+k;
                if(i == j)
                {
                    t[i][j] = 1;
                }
                else
                {
                    if(p.charAt(i) == p.charAt(j))
                    {
                        t[i][j] = 2 + t[i+1][j-1];
                    }
                    else
                    {
                        t[i][j] = Math.max(t[i+1][j], t[i][j-1]);
                    }
                }
            }
        }
        return t[0][p.length()-1];
    }
    public static void main(String[] args) 
    {
        String p = "abckycbc";
        int[][] t = new int[p.length()][p.length()];
        int ans = lps(t, p);
        System.out.println(ans);
    }
}