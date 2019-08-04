import java.util.*;
public class subset
{
    static boolean checkSum(int[] a, boolean[][]t, int n)
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < t[0].length; j++)
            {
                if(i==0 && j==0)
                {
                    t[i][j] = true;
                }
                else if(i==0)
                {
                    t[i][a[i]] = true;
                }
                else if(j==0)
                {
                    t[i][j] = true;
                }
                else
                {
                    if(t[i-1][j] == true)
                    {
                        t[i][j] = true;
                    }
                    else
                    {
                        if(j>=a[i])
                        {
                            if(t[i-1][j-a[i]] == true)
                            {
                                t[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return t[t.length-1][t[0].length-1];
    }
    public static void main(String[] args) 
    {
        int[] a = {3, 2, 5, 1, 8};
        int n = 9;
        boolean[][] t = new boolean[a.length][n+1];
        boolean ans = checkSum(a, t, 1);
        System.out.println(ans);
    }
}