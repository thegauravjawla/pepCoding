import java.util.*;
public class longestPalindromicSubstring
{
    static int lps(String s, boolean[][] t)
    {
        //false=yes, true=no
        int ans = 0;
        for(int k = 0; k < s.length(); k++)
        {
            for(int i = 0; i < s.length()-k; i++)
            {
                int j = i+k;
                if(i==j)
                {
                    t[i][j] = false;
                }
                else
                {
                    if(s.charAt(i) == s.charAt(j) && t[i+1][j-1] == false)
                    {
                        t[i][j] = false;
                        ans = k;
                    }
                    else
                    {
                        t[i][j] = true;
                    }
                }
            }
        }
        return ans+1;
    }
    public static void main(String[] args) 
    {
        String s = "abcbc";
        boolean[][] t = new boolean[s.length()][s.length()];
        int ans = lps(s, t);
        System.out.println(ans);
    }
}