import java.util.*;
public class prime
{
    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int n;
        for(int j = 0; j < t; j++)
        {
            boolean flag = true;
            n = scn.nextInt();
            for (int i = 2; i*i <= n; i++)
            {
                if (n%i == 0)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                System.out.println("Prime!");
            }   
            else
            {
                System.out.println("Not Prime!");
            }         
        }
    }
}