import java.util.*;
public class inverseNumber
{
    public static void main(String[] argv)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i;
        int nn = n;
        for (i = 0;n != 0;i++)
        {
            n = n/10;
        }
        int d;
        int ten = 10;
        int inverse = 0;
        for (int j = 0; nn != 0; j++)
        {
            d = n % ten;
            int t = 10;
            for(int k = 1; k <= d; k++)
            {
                t = t*(10);
            }
            System.out.println(t);
            inverse = inverse + j*t;
            nn = nn/ten;
            ten = ten*10;
        }
        System.out.println(inverse);
    }
}