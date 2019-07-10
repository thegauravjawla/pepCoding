import java.util.*;
public class nthFibonacci
{
    public static void main(String[] argv)
    {
        int m, nn, temp;
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        m = 0;
        nn = 1;
        for(int i = 0; i < n; i++)
        {
            System.out.println(nn);
            temp = m;
            m = nn;
            nn = temp+nn;
        }
        

    }
}