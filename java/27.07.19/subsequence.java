import java.util.*;
public class subsequence
{
    static int getSub(char[] s)
    {
        int i=0, j=0, k=0;
        for(char c: s)
        {
            if(c == 'a')
            {
                if(i == 0)  i++;
                else
                {
                    i = 2*i+1;
                }
            }
            else if(c == 'b')
            {
                if(j == 0)  j++;
                else
                {
                    j = 2*j+i;
                }
            }
            else if(c == 'c')
            {
                if(k == 0)  k++;
                else 
                {
                    k = 2*k+j;
                }
            }
        }
        return k;
    }
    public static void main(String[] args) 
    {
        String str = "abcabc";
        char[] s = str.toCharArray();
        int ans = getSub(s);
        System.out.println(ans);
    }
}