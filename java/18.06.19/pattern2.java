import java.util.*;
public class pattern2
{
    public static void main(String[] argv)
    {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        for (int i = 0; i < n; i++)
        {
            int val = 1;
            for(int j = 0; j <= i; j++)
            {
                System.out.print(val + "\t");
                val = val * (i-j) / (j+1);
            }
            System.out.println();
        }
    }
}