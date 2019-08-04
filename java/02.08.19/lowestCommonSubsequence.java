import java.util.*;
public class lowestCommonSubsequence
{
    static int lcs(int[][] t, String p, String q)
    {
        for(int i = p.length(); i>=0; i--)
        {
            for(int j = q.length(); j>=0; j--)
            {
                if(i == p.length() || j == q.length())
                {
                    t[i][j] = 0;
                }
                else 
                {
                    if(p.charAt(i) == q.charAt(j))
                    {
                        t[i][j] = t[i+1][j+1] + 1;
                    }
                    else
                    {
                        t[i][j] = Math.max(t[i+1][j], t[i][j+1]);
                    }
                }
            }
        }
        return t[0][0];
    }
    public static void main(String[] args) 
    {
        String p = "abcd";
        String q = "aebd";
        int[][] t = new int[p.length()+1][q.length()+1];
        int ans = lcs(t, p, q);
        System.out.println(ans);
    }
}