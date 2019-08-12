import java.util.*;
public class minimumPalindromeCut
{
    static int mpc(String s, int[][] t)
    {
        for(int k = 0; k < s.length(); k++)
        {
            for(int i = 0; i < s.length()-k; i++)
            {
                int j = i+k;
                if(i == j)
                {
                    t[i][j] = 0;
                }
                else if(s.charAt(i) == s.charAt(j) && t[i+1][j-1] == 0)
                {
                    t[i][j] = 0;
                }
                else
                {
                    int min = s.length();
                    for(int l = 1; l < k+1; l++)    //l represents the amount you went down or right to do the matrix multiplication thingie!
                    {
                        int right = t[i][j-k+l+1];    //right from the beginning point of matrix multiplication thingie!
                        int down = t[i+l][j];
                        if(min > right+down)
                        {
                            min = right+down;
                        }
                    }
                    t[i][j] = min + 1;
                }
            }
        }
        return t[0][s.length()-1];
    }
    public static void main(String[] args) 
    {
        String s = "bccbc";
        int[][] t = new int[s.length()][s.length()];
        int ans = mpc(s, t);
        System.out.println(ans);
    }
}