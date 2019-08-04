import java.util.*;
public class singleFriend
{
    public static void main(String[] args) 
    {
        int n = 4;
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;
        for(int i = 2; i < n+1; i++)
        {
            t[i] = t[i-1] + (i-1)*t[i-2];
        }
        System.out.println(t[n]);
    }
}