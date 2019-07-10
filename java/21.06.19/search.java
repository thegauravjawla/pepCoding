import java.util.*;
public class search
{
    public static void main(String[] argv)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = scn.nextInt();
        }
        int toSearch = scn.nextInt();
        for(int i = 0; i < a.length; i++)
        {
            if (a[i] == toSearch)
            {
                System.out.println("Index = " + i);
                return;
            }
        }
        System.out.println("Data not found!");
        
    }
}