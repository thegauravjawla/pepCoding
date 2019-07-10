import java.util.*;
public class sumOfArrays
{
    public static void main(String[] argv) 
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[] n1 = new int[m];
        for (int i = 0; i < m; i++)
        {
            n1[i] = scn.nextInt();
        }
        int[] n2 = new int[n];
        for (int i = 0; i < n; i++)
        {
            n2[i] = scn.nextInt();
        }   
        // inputs done     
        int[] sum = new int[n1.length >= n2.length? n1.length + 1:n2.length + 1];
        int i = n1.length - 1;
        int j = n2.length - 1;
        int k = sum.length - 1;
        int carry = 0;
        int var;
        int digit;
        while(k>=0)
        {
            var = carry;
            if(i >=0)
                var += n1[i];
            if(j >= 0)
                var += n2[j];  
            digit = var % 10;
            carry = var / 10;
            sum[k] = digit;
            i--;k--;j--;
        }

        // print output
        for(i = 0; i < sum.length; i++)
        {
            if(sum[i] == 0 && i == 0)
                continue;
            System.out.print(sum[i]);    
        }    
    }
}