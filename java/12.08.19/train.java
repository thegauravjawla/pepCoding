import java.util.*;
public class train
{
    static int maxStation(int[] a, int[] d)
    {
        int num = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while(true)
        {
            if(a[i] <= d[j])
            {
                num++;
                i++;
            }
            else if(a[i] > d[j])
            {
                num--;
                j++;
            }

            //base case
            if(j == d.length)
            {
                num+=(j-i);
                break;
            }
            if(i == a.length)
            {
                num+=(i-j);
                break;
            }
            if(num > max)   max = num;
        }
        return max;
    }
    public static void main(String[] args) 
    {
        int[] a = {900, 940, 950, 1100, 1500, 1800};
        int[] d = {910, 1200, 1120, 1130, 1900, 2000};
        Arrays.sort(a);
        Arrays.sort(d);
        int ans = maxStation(a, d);
        System.out.println(ans);
    }
}