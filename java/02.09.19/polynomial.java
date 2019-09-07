import java.util.*;
public class polynomial
{
    static int f(int x, int n)
    {
        int sum = 0;
        int xval = x;
        while(n!=0)
        {
            sum+=x*n;
            n-=1;
            x = x*xval;
        }
        return sum;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int ans = f(x, n);
        System.out.println(ans);
    }
}