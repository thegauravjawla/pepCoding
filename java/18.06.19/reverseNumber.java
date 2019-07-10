import java.util.*;
public class reverseNumber
{
    public static void main(String[] argv)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ten = 10;
        int d = 0;
        int j;
        int revNum = 0;
        // for (j = 0; n != 0; j++)
        // {
        //     n = n/10;
        // }
        for (int i = 0; n != 0; i++)
        {
            d = n%ten;
            System.out.print(d);
            n = n/ten;
            d = d*10;
        }
    }
}