import java.util.*;
public class patternFibonacci
{
    public static void main(String[] argv)
    {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int p = 0;
        int q = 1;
        int temp;
        for (int i = 1; i <= n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                System.out.print(p + " ");
                temp = p + q;
                p = q;
                q = temp;
            }    
            System.out.println();
        }
    }
}