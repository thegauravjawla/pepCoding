import java.util.*;
public class permutation2
{
    public static void nPr(boolean[] items, int n, int r, int currentBox, int count, String ans)
    {
        if(currentBox == n)
        {
            if(count == r)
                System.out.println(ans);
            return;
        }
        nPr(items, n, r, currentBox + 1, count, ans);   //the box is not choosen at all!
        for(int i = 0; i < r; i++)                      //box is choosen, and now we put all elements one by one!
        {
            if(items[i] == false)
            {
                items[i] = true;
                nPr(items, n, r, currentBox + 1, count + 1, ans + " item "+ i + " in " + currentBox);
                items[i] = false;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        boolean[] objects = new boolean[r];
        nPr(objects, n, r, 0, 0, "");
    }
}