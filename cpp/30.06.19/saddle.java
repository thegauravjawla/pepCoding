import java.util.*;
public class saddle
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] a= new int[r][c];
        int ii, jj, max, min;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                a[i][j] = scn.nextInt();

            }
        }
        int flag;
        for(int i = 0; i < r; i++)
        {
            min = a[i][0];
            jj = 0;
            for(int j = 1; j < c; j++)
            {
                if(min > a[i][j])
                {
                    min = a[i][j];
                    jj = j;
                }
            }
            flag = 0;
            for(int k = 0; k < r; k++)
            {
                flag++;
                if(min <= a[k][jj])
                {
                    break;
                }
            }
            if(flag == r)
            {
                System.out.println(a[i][jj]);
                return;
            }
        }
        System.out.println("No Such Point Exist");
    }
}