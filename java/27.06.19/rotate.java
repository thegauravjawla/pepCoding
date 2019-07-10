import java.util.*;
public class rotate
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

        int temp;
        // transpose of the matrix

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j <=i; j++)
            {
                temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        //swapping the columns

        for (int i = 0; i < m; i++)
        {
            int l = 0, r = n - 1;
            while(l < r)
            {
                temp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = temp;
                l++;r--;
            }
        }
        
        //display

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}