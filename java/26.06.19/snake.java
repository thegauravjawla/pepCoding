import java.util.*;
public class snake
{
    public static void main(String[] argc)
    {
        int[][] a = {
            {0, 0, 1, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 1, 0}
        };
        int i = 0, j = 0;
        int d = 0;
        while(i < a.length && j < a[0].length)
        {
            if(a[i][j] == 1)
                d = (d + a[i][j]) % 4;

            if(d == 0)
                j++;
            else if(d == 1)
                i++;
            else if(d == 2)
                j--;
            else
                i--;
        }

        if(d == 0)
            j--;
        else if(d == 1)
            i--;
        else if(d == 2)
            j++;
        else
            i++;

        System.out.println("(" + i + "," + j + ")");
    }
}