import java.util.*;
public class subsetBFS
{
    public static class Position
    {
        int i;
        int j;
        String ans;
        Position(int i, int j, String ans)
        {
            this.i = i;
            this.j = j;
            this.ans = ans;
        }
    }
    static void checkSum(int[] a, boolean[][]t, int n)
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < t[0].length; j++)
            {
                if(i==0 && j==0)
                {
                    t[i][j] = true;
                }
                else if(i==0)
                {
                    t[i][a[i]] = true;
                }
                else if(j==0)
                {
                    t[i][j] = true;
                }
                else
                {
                    if(t[i-1][j] == true)
                    {
                        t[i][j] = true;
                    }
                    else
                    {
                        if(j>=a[i])
                        {
                            if(t[i-1][j-a[i]] == true)
                            {
                                t[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
    }
    static void getSubset(int[]a, boolean[][]t)
    {
        ArrayDeque <Position> q = new ArrayDeque<>();
        Position p = new Position(t.length-1, t[0].length-1, "");
        q.push(p);


        while(q.size() > 0)
        {
            Position remove = q.pop();
            if(remove.i == 0)
            {
                if(remove.j == 0)
                {
                    System.out.println(remove.ans);
                }
                else if(remove.j == a[0])
                {
                    System.out.println(remove.ans + a[0]);
                }
                continue;
            }
            if(t[remove.i-1][remove.j] == true)
            {
                p = new Position(remove.i-1, remove.j, remove.ans + a[remove.i]);
                q.push(p);
            }
            if(remove.j >= a[remove.i])
            {
                if(t[remove.i-1][remove.j-a[remove.i]] == true)
                {
                    p = new Position(remove.i-1, remove.j-a[remove.i], remove.ans + a[remove.i]);
                    q.push(p);
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        int[] a = {3, 2, 5, 1, 8};
        int n = 9;
        boolean[][] t = new boolean[a.length][n+1];
        checkSum(a, t, 1);
        getSubset(a, t);
    }
}