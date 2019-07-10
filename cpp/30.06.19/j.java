import java.util.*;
public class j
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] a= new int[r][c];
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                a[i][j] = scn.nextInt();
            }
        }

        for(int i = 0; i < r; i++)
        {
            int ii = i;
            int j = 0;
            while(ii != -1 && j != c)
            {
                System.out.print(a[ii][j] + " ");
                ii--;
                j++;
            }
            System.out.println();
        }
        for(int j = 1; j < c; j++)
        {
            int ii = r-1;
            int jj = j;
            while(jj != c)
            {
                System.out.print(a[ii][jj] + " ");
                ii--;
                jj++;
            }
            System.out.println();
        }
    }
}