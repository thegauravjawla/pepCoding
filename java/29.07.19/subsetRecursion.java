import java.util.*;
public class subsetRecursion
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

    static void getSubset(boolean[][] t, int i, int j, int[] a, String ans)
    {
        if(i == 0)
        {
            if(j == 0)
            {
                System.out.println(ans);
            }
            else if(j == a[0])
            {
                System.out.println(ans + a[0]);
            }
            return;
        }
        else
        {
            if(t[i-1][j])
            {
                getSubset(t, i-1, j, a, ans);
            }
            if(j>=a[i])
            {
                if(t[i-1][j-a[i]])
                {
                    getSubset(t, i-1, j-a[i], a, ans + a[i]);
                }
            }
        }
        return;
    }

    public static void main(String[] args) 
    {
        int[] a = {3, 2, 5, 1, 8};
        int n = 9;
        boolean[][] t = new boolean[a.length][n+1];
        boolean ans = checkSum(a, t, 1);
        getSubset(t, t.length-1, t[0].length-1, a, "");
        System.out.println(ans);
    }
}