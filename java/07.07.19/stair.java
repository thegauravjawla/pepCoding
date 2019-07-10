import java.util.*;
public class stair
{
    public static void step(int n, String ans)
    {
        if(n == 0)
        {
            System.out.println(ans);
            return;
        }
        else if(n < 0)
        {
            return;
        }

        step(n-1, 1 + ans);
        step(n-2, 2 + ans);
        step(n-3, 3 + ans);
        return;
    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        step(n, "");
    }
}