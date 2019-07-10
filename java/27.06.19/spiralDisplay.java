import java.util.*;
public class spiralDisplay
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                a[i][j] = scn.nextInt();
            }
        }

        int mini = 0;
        int maxi = m - 1;
        int minj = 0;
        int maxj = n - 1;
        int count = 1;

        //limit of while is not right!!!!
        while(true)
        {   
            for(int i = mini; i <= maxi; i++)
            {
                System.out.print(a[i][minj] + " ");
            }
            minj++;
            if(mini > maxi || minj > maxj)
                break;            

            for(int j = minj; j <= maxj; j++)
            {
                System.out.print(a[maxi][j] + " ");
            }
            maxi--;
            if(mini > maxi || minj > maxj)
                break;            

            for(int i = maxi; i >= mini; i--)
            {
                System.out.print(a[i][maxj] + " ");
            }
            maxj--;
            if(mini > maxi || minj > maxj)
                break;            

            for(int j = maxj; j >= minj; j--)
            {
                System.out.print(a[mini][j] + " ");
            }   
            mini++;
            if(mini > maxi || minj > maxj)
                break;

            count++;    
        }
    }
}