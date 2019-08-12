import java.util.*;
public class maxActivities
{
    static class Interval implements Comparable<Interval>
    {
        int s;
        int e;
        Interval(int s, int e)
        {
            this.s = s;
            this.e = e;
        }
        public int compareTo(Interval other)    //to sort on the basis of start
        {
            return this.s - other.s;
        }
    }

    static int maxActivity(Interval[] act, int[] t)
    {
        t[0] = 1;
        for(int i = 1; i < t.length; i++)
        {
            int max = -1;
            for(int j = 0; j < i; j++)
            {
                if(act[i].s >= act[j].e)
                {
                    if(max < t[j])
                    {
                        max = t[j];
                    }
                }
            }
            t[i] = max+1;
        }
        return t[t.length-1];
    }
    public static void main(String[] args) 
    {
        int[] start = {12, 2, 6, 7, 9, 3, 3};
        int[] end = {14, 5, 8, 10, 11, 4, 7};
        int[] t = new int[start.length];
        Interval[] act = new Interval[start.length];
        for(int i = 0; i < start.length; i++)
        {
            act[i] = new Interval(start[i], end[i]);
        }
        Arrays.sort(act);
        int ans = maxActivity(act, t);
        System.out.println(ans);
    }
}