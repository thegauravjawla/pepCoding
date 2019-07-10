import java.util.*;
public class maze
{
    public static void getPath(int sr, int sc, int er, int ec, String ans)
    {
        if(sr == er && sc == ec)
        {
            System.out.println(ans);
            return;
        }
        if(sc < ec)
            {getPath(sr, sc + 1, er, ec, ans + "H");}
        if(sr < er)
            {getPath(sr + 1, sc, er, ec, ans + "V");}
        return;
    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        getPath(0, 0, m-1, n-1, "");
    }
}