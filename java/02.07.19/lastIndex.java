import java.util.*;

public class lastIndex
{
    public static int lastInd(int[] a, int x, int index)
    {
        if(index == a.length)
            return -1;

        int lastIndOfSmall = lastInd(a, x, index + 1);

        if(lastIndOfSmall != -1)    //if found before, just return the preveously found index
            return lastIndOfSmall;
        else if(a[index] == x)      //if not found before but just now, return the current index
            return index;
        else                       //neither found before nor now, return -1
            return -1;
            
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
        int x = scn.nextInt();
        System.out.println(lastInd(a, x, 0));
    }
}