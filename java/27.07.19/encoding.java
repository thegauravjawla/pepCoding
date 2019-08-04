import java.util.*;
public class encoding
{

    static int getEncoding(int[] n, int[] t)
    {
        if(n[0] == 0)   return 0;
        //t[n-1] is the ans for n = n;
        
        t[0] = 1;
        if(n[1] != 0)
        {
            t[1] = t[0];
        }
        if(n[0]*10 + n[1] < 27 && n[0]*10 + n[1]>=10)
        {
            t[1]+=1;
        }
        for(int i = 2; i < t.length; i++)
        {
            if(n[i] != 0)
            {
                t[i] = t[i-1];
            }
            if(n[i-1]*10 + n[i] < 27 && n[i-1]*10 + n[i]>=10)
            {
                t[i]+=t[i-2];
            }
        }
        return t[t.length-1];
    }
    public static void main(String[] args) 
    {
        int[] n = {1, 2, 1, 3, 2, 6, 1, 2, 0, 1, 4};
        int[] t = new int[n.length];
        int ans = getEncoding(n, t);
        System.out.println(ans);
    }
}