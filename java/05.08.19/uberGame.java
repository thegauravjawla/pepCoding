import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

class uberGame 
{
    static int maxProfit(int[] n, int i, int j)
    {
        if(i==j)
        {
            return 0;
        }
        if((j-i+1)%2==0)
        {
            int a = maxProfit(n, i+1, j);
            int b = maxProfit(n, i, j-1);
            
            if(a+n[i] < b+n[j])
                return b+n[j];
            return a+n[i];
        }
        else
        {
            int a = maxProfit(n, i+1, j);
            int b = maxProfit(n, i, j-1);
            
            if(a+n[i] > b+n[j]) return b;
            else return a;
        }
    }
    
	public static void main (String[] args) throws FileNotFoundException
	{
        // Scanner scn = new Scanner(System.in);
        File file = new File("C:\\Users\\gaura\\Codes\\pepCoding\\java\\05.08.19\\uberGameIn.txt");
        Scanner scn = new Scanner(file);
        PrintStream o = new PrintStream(new File("uberGameOut.txt"));
        System.setOut(o);
        int t = scn.nextInt();
        for(int j = 0; j < t; j++)
        {
            int l = scn.nextInt();
		    int[] n = new int[l];
            for(int i = 0; i < l; i++)  n[i] = scn.nextInt();
            if(l%2!=0)
            {
                System.out.println("ERROR!");
                continue;
            }
            int ans = maxProfit(n, 0, n.length-1);
            System.out.println(ans);
        }
	}
}
// 6
// 20 30 2 2 2 10
//Output-> 42