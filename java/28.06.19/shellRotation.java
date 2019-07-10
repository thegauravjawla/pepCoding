import java.util.*;
public class shellRotation
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] a = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                a[i][j] = scn.nextInt();
            }
        }

        //main algorithm
        int s = scn.nextInt();  //shell number
        int r = scn.nextInt();  //rotation

        int t1 = a[s-1][s-1];
        int t2;

        // code only for one rotation!
        for(int i = s - 1; i < m - s; i++)
        {
            t2 = a[i + 1][s-1];
            a[i + 1][s-1] = t1;
            t1 = t2;
        }

        for(int j = s - 1; j < n - s; j++)
        {
            t2 = a[m-s][j + 1];
            a[m-s][j + 1] = t1;
            t1 = t2;
        }

        for(int i = m - s; i > s-1; i--)
        {
            t2 = a[i - 1][n-s];
            a[i - 1][n-s] = t1;
            t1 = t2;
        }

        for(int j = n - s; j > s-1; j--)
        {
            t2 = a[s - 1][j - 1];
            a[s - 1][j - 1] = t1;
            t1 = t2;
        }

        //print the array
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
