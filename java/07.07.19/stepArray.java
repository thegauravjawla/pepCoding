import java.util.*;
public class stepArray
{
    public static void step(int[] a, int index, String ans)
    {
        if(index == a.length - 1)
        {
            System.out.println(ans);
            return;
        }
        else if(index >= a.length)
        {
            return;
        }
        //
        int currentStepLimit = a[index];
        for(int i = 1; i <= currentStepLimit; i++)
        {
            step(a, index + i, ans + i);
        }
        return;
        //
    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }
        step(a, 0, "");
    }
}