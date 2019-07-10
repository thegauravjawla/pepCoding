import java.util.*;
public class multiMaze
{
    public static void getPath(int sr, int sc, int er, int ec, String ans)
    {

    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        getPath(0, 0, m-1, n-1, "");
    }
}
0 1 0 0 0 0 0 0 0 
0 1 0 1 1 1 1 1 0 
0 1 0 1 0 0 0 0 0 
