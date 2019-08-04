import java.util.*;
public class longestPalindromicSubstring2
{
    static int lps(String s, int[][] t)
    {
        int ans = 0;
        for(int k = 0; k < s.length(); k++)
        {
            for(int i = 0; i < s.length()-k; i++)
            {
                int j = i+k;
                if(i==j)
                {
                    t[i][j] = k+1;
                }
                else
                {
                    if(s.charAt(i) == s.charAt(j) && t[i+1][j-1] == k-2)
                    {
                        t[i][j] = k+1;
                    }
                    else
                    {
                        t[i][j] = Math.max(t[i+1][j], t[i][j-1]);
                    }
                }
            }
        }
        return t[0][s.length()-1];
    }
    public static void main(String[] args) 
    {
        String s = "abccbc";
        int[][] t = new int[s.length()][s.length()];
        int ans = lps(s, t);
        System.out.println(ans);
    }
}