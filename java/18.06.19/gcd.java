import java.util.*;
public class gcd
{
    public static void main(String[] argv)
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int temp = 0;
        int g = 1;
        for(int i = 0; m%n != 0; i++)
        {
            temp = m%n;
            m = n;
            n = temp;
        }
        System.out.println(temp);
    }
}