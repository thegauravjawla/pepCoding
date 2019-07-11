import java.util.*;
public class combination2
{
    public static void nCr(int n, int r, int currentBox, int count, String ans)
    {
        if(currentBox == n)
        {
            if(count == r)
                System.out.println(ans);
            return;
        }
        //Another version of base condition!//////////////////////////////////////
        //
        // if(count == r)
        // {
        //     System.out.println(ans);
        //     return;
        // }
        // if(currentBox == n)
        // {
        //     return;
        // }
        //
        /////////////////////////////////////////////////////////////////////////

        nCr(n, r, currentBox + 1, count + 1, ans + currentBox); // choosing current box

        nCr(n, r, currentBox + 1, count, ans);                  //not choosing the current box

        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // boolean[] boxes = new boolean[n];
        int objects = scn.nextInt();
        nCr(n, objects, 0, 0, "");
    }
}