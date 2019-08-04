import java.util.*;
public class coinChange
{
    static int nPr(int[] c, int[] t)
    {
        t[0] = 1;
        for(int i = 1; i < t.length; i++)
        {
            for(int j = 0; j < c.length; j++)
            {
                if(i - c[j] >= 0)
                {
                    t[i]+=t[i-c[j]];
                }
            }
        }
        return t[t.length-1];
    }

    static int nCr(int[] c, int[] t)
    {
        t[0] = 1;
        for(int j = 0; j < c.length; j++)
        {
            for(int i = 1; i < t.length; i++)
            {
                if(i - c[j] >= 0)
                {
                    t[i]+=t[i-c[j]];
                }
            }
        }
        return t[t.length-1];
    }
    public static void main(String[] args)
    {
        int[] c = {2, 3, 5, 6}; //coin
        int m = 7;  //money needed
        int[] t = new int[m+1];
        System.out.println(nCr(c, t));
        t = new int[m+1];
        System.out.println(nPr(c, t));
    }
}