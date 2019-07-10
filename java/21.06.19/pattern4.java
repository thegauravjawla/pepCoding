import java.util.*;
public class pattern4
{
    public static void main(String[] argv)
    {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int nsp = 2*n - 3, nst = 1;
        int val = 1;
        for (int i = 0; i < n; i++)
        {
            val = 1;
            for (int j = 0; j < nst; j++)
            {
                System.out.print(val + " ");
                val++;
            }
            for (int j = 0; j < nsp; j++)
            {
                System.out.print("  ");
            }
            val--;
            if(nsp < 0)
                val--;
            for (int j = nsp < 0?1:0; j < nst; j++)
            {
                System.out.print(val + " ");     
                val--;
            }                        
            if(nsp < 0)
                break;
            nsp -= 2;
            nst ++;
            System.out.println();
        }
    }
}