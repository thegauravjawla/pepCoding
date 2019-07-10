import java.util.*;
public class multiMaze
{
    public static void getPath(int sr, int sc, int er, int ec, String ans)
    {
        if(sr == er && sc == ec)
        {
            System.out.println(ans);
            return;
        }
        for(int i = 1; sc + i <= ec; i++)
        {
            getPath(sr, sc + i, er, ec, ans + "H" + i);
        }
        for(int i = 1; sr + i <= er; i++)
        {
            getPath(sr + i, sc, er, ec, ans + "V" + i);
        }
        for(int i = 1; sc + i <= ec && sr + i <= er; i++)
        {
            getPath(sr + i, sc + i, er, ec, ans + "D" + i);
        }
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