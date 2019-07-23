import java.util.*;
public class fireStorm
{
    static class point
    {
        int x;
        int y;
        int t;  //time at which it burns
    }

    static void solve(int[][] city, int time)
    {
        ArrayDeque<point> q = new ArrayDeque<>();
        for(int i = 0; i < city.length; i++)
        {
            for(int j = 0; j < city[0].length; j++)
            {
                if(city[i][j] == 1)
                {
                    point p = new point();
                    p.x = i;
                    p.y = j;
                    p.t = 1;
                    q.addLast(p);
                }
            }
        }
        
        while(q.size() > 0)
        {
            point toRemove = q.getFirst();
            q.removeFirst();

            if(toRemove.t == time + 2)    break;
            if(city[toRemove.x][toRemove.y] < 0)    continue;

            city[toRemove.x][toRemove.y] = -toRemove.t;

            //top
            if(toRemove.x-1>=0 && city[toRemove.x - 1][toRemove.y] == 0)
            {
                point p = new point();
                p.x = toRemove.x-1;
                p.y = toRemove.y;
                p.t =toRemove.t + 1;
                q.addLast(p);
            }
            //down
            if(toRemove.x+1<city.length && city[toRemove.x + 1][toRemove.y] == 0)
            {
                point p = new point();
                p.x = toRemove.x + 1;
                p.y = toRemove.y;
                p.t =toRemove.t + 1;
                q.addLast(p);
            }
            //left
            if(toRemove.y-1>=0 && city[toRemove.x][toRemove.y - 1] == 0)
            {
                point p = new point();
                p.x = toRemove.x;
                p.y = toRemove.y-1;
                p.t =toRemove.t + 1;
                q.addLast(p);
            }
            //right
            if(toRemove.y+1<city[0].length && city[toRemove.x][toRemove.y + 1] == 0)
            {
                point p = new point();
                p.x = toRemove.x;
                p.y = toRemove.y+1;
                p.t =toRemove.t + 1;
                q.addLast(p);
            }
        }
    }
    public static void main(String[] argc)
    {
        int[][] city = {
                        {1, 2, 0, 2, 0, 0, 0},
                        {0, 2, 0, 2, 0, 1, 0},
                        {0, 0, 0, 2, 0, 0, 0},
                        {2, 2, 2, 2, 2, 2, 0},
                        {0, 2, 1, 0, 0, 0, 0},
                        {0, 2, 0, 0, 0, 0, 0},
                        {0, 2, 0, 0, 0, 0, 0}
                                              };
        int time = 3;
        solve(city, time);
        //print
        for(int i = 0; i < city.length; i++)
        {
            for(int j = 0; j < city[0].length; j++)
            {
                System.out.print(city[i][j] + "\t");
            }
            System.out.println();
        }
    }
}