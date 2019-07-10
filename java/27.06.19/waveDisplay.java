fimport java.util.*;
public class waveDisplay
{
    public static void main(String[] argc)
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

        for (int j = 0; j < n; j++)
        {
            if (j % 2 == 0)
            {
                for (int i = 0; i < m; i++)
                {
                    System.out.print(a[i][j] + " ");
                }
            }
            else
            {
                for (int i = m-1; i >= 0; i--)
                {
                    System.out.print(a[i][j] + " ");
                }
            }
        }
    }
}