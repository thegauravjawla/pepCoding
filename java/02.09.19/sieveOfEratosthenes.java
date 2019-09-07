import java.util.*;
public class sieveOfEratosthenes
{
    static void sieve(int n)
    {
        boolean[] s = new boolean[n+1];
        s[0] = true;
        s[1] = true;
        int i = 2;
        while(i*i<=n)
        {
            if(s[i] == false)
            {
                for(int j = i; i*j <=n ;j++)
                {
                    s[i*j] = true;
                }
            }
            i++;
        }

        for(int j = 0; j <= n; j++)
        {
            if(s[j] == false)
                System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        sieve(n);
    }
}