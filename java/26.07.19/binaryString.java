import java.util.*;
public class binaryString
{
    static int count(int[] t)
    {
        t[0] = 1;
        t[1] = 2;
        for(int i = 2; i < t.length; i++)
        {
            t[i] = t[i-1] + t[i-2];
        }
        return t[t.length-1];
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] t = new int[n+1]; //although it is not needed, only 2 variables are sufficient
        int ans = count(t);
        System.out.println(ans);
    }
}

//first calculate the number of ans you get from (n-1) ending from 0 and 1;
//And then add 1 at the end of "0 wala" and 1 and 0 both to "1 wala"