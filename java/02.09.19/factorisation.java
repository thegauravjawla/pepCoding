import java.util.*;
public class factorisation
{
    static int[] sieve(int n)
    {
        //to get the smallest factor of a number
        int[] factor = new int[n+1];
        boolean[] s = new boolean[n+1];
        s[0] = true;
        s[1] = true;
        for(int i = 0; i < n+1; i++)
        {
            factor[i] = i;
        }
        int i = 2;
        while(i*i<=n)
        {
            if(s[i] == false)
            {
                for(int j = i; i*j <=n;j++)
                {
                    if(s[i*j] == false)
                    {
                        s[i*j] = true;
                        factor[i*j] = i;
                    }
                }
            }
            i++;
        }
        return factor;
    }

    static void factorsOf(int n, int[] smallestFactor)
    {
        while(n > 1)
        {
            System.out.print(smallestFactor[n] + " ");
            n = n/smallestFactor[n];
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] smallestFactor = sieve(n);
        factorsOf(n, smallestFactor);
    }
}