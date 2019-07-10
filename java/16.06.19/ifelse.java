import java.util.*;

public class ifelse
{
    public static void main(String[] args)
    {
        int e1s = 0;
        int e1e = 10;
        int e2s = 3;
        int e2e = 13;

        if (e1e < e2s || e2e < e1s)
        {
            System.out.println("No Overlap");
        }
        else
        {
            if((e2s > e1s && e2e < e1e) || (e1s > e2s && e1e < e2e))
            {
                System.out.println("Full Overlap");
            }
            else
            {
                System.out.println("Patial Overlap");
            }
        }
    }
}
// Reviewed by Amrit


