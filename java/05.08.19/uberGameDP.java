import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

class uberGameDP
{
    static int maxProfit(int[][] t, int[] n)
    {
        for(int k = 0; k < t.length; k++)
        {
            if(k%2==0)  continue;
            for(int i = 0; i < t.length-k; i++)
            {
                int j = i+k;
                if(k==1)
                {
                    t[i][j] = Math.max(n[i], n[j]);
                }
                else
                {
                    int v1 = n[i] + Math.min(t[i+1][j-1], t[i+2][j]);
                    int v2 = n[j] + Math.min(t[i+1][j-1], t[i][j-2]);
                    t[i][j] = Math.max(v1, v2);
                }
            }
        }
        // for(int i = 0; i < t.length; i++)
        // {
        //     for(int j = 0; j < t.length; j++)
        //     {
        //         System.out.print(t[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return t[0][t.length-1];
    }
    
	public static void main (String[] args) throws FileNotFoundException
	{
        // Scanner scn = new Scanner(System.in);
        File file = new File("C:\\Users\\gaura\\Codes\\pepCoding\\java\\05.08.19\\uberGameIn.txt");
        Scanner scn = new Scanner(file);
        PrintStream o = new PrintStream(new File("uberGameDPOut.txt"));
        System.setOut(o);
        int t = scn.nextInt();
        for(int j = 0; j < t; j++)
        {
            int l = scn.nextInt();
            int[] n = new int[l];
            int[][] tb = new int[l][l];
            for(int i = 0; i < l; i++)  n[i] = scn.nextInt();
            if(l%2!=0)
            {
                System.out.println("ERROR!");
                continue;
            }
            int ans = maxProfit(tb, n);
            System.out.println(ans);
        }
	}
}