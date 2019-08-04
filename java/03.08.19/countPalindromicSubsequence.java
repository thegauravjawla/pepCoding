import java.util.*;
public class countPalindromicSubsequence
{
    static int cps(String s, int[][] t)
    {
        for(int k = 0; k < s.length(); k++)
        {
            for(int i = 0; i < s.length()-k; i++)
            {
                int j = i+k;
                if(i==j)
                {
                    t[i][j] = 1;
                }
                else
                {
                    if(s.charAt(i) == s.charAt(j))
                    {
                        t[i][j] = t[i+1][j] + t[i][j-1] + 1;
                    }
                    else
                    {
                        t[i][j] = t[i+1][j] + t[i][j-1] - t[i+1][j-1];
                    }
                }
            }
        }
        return t[0][s.length()-1];
    }
    public static void main(String[] args) 
    {
        String s = "abckycbc";
        int[][] t = new int[s.length()][s.length()];
        int ans = cps(s, t);
        System.out.println(ans);
    }
}