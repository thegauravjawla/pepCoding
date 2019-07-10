import java.util.*;
public class matrixMultiplication
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);

        //input matrix 1
        int m1 = scn.nextInt();
        int n1 = scn.nextInt();
        int[][] a = new int[m1][n1];
        for (int i = 0; i < m1; i++)
        {
            for(int j = 0; j < n1; j++)
            {
                a[i][j] = scn.nextInt();
            }
        }

        //input matrix 2
        int m2 = scn.nextInt();
        int n2 = scn.nextInt();
        if(n1 != m2)    //condition of matrix multiplication
            return;
        int[][] b = new int[m2][n2];
        for (int i = 0; i < m2; i++)
        {
            for(int j = 0; j < n2; j++)
            {
                b[i][j] = scn.nextInt();
            }
        }

        for(int i = 0; i < m1; i++)
        {
            for(int j = 0; j < n2; j++)
            {
                int sum = 0;
                for (int ii = 0; ii < n1; ii++)
                {
                    sum += a[i][ii]*b[ii][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}