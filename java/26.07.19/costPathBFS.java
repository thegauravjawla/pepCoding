import java.util.*;
public class costPathBFS
{
    public static class Pair
    {
        int i;
        int j;
        String ans;

        Pair(int i, int j, String ans)
        {
            this.i = i;
            this.j = j;
            this.ans = ans;
        }
    }

    static void bfs(int[][] t)
    {
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        Pair p = new Pair(0, 0, "");
        q.add(p);

        while(q.size() > 0)
        {
            Pair remove = q.remove();
            
            if(remove.i+1 == t.length && remove.j+1 == t[0].length)
            {
                System.out.println(remove.ans);
                continue;
            }
            else if(remove.i+1 == t.length)
            {
                p = new Pair(remove.i, remove.j+1, remove.ans + "H");
                q.add(p);
            }
            else if(remove.j+1 == t[0].length)
            {
                p = new Pair(remove.i+1, remove.j, remove.ans + "V");
                q.add(p);
            }
            else
            {
                if(t[remove.i+1][remove.j] < t[remove.i][remove.j+1])
                {
                    p = new Pair(remove.i+1, remove.j, remove.ans + "V");
                    q.add(p);
                }
                else if(t[remove.i+1][remove.j] > t[remove.i][remove.j+1])
                {
                    p = new Pair(remove.i, remove.j+1, remove.ans + "H");
                    q.add(p);
                }
                else
                {
                    p = new Pair(remove.i, remove.j+1, remove.ans + "H");
                    q.add(p);
                    p = new Pair(remove.i+1, remove.j, remove.ans + "V");
                    q.add(p);
                }
            }
        }
    }

    static void getCost(int[][] maze, int[][] t)
    {
        for(int i = maze.length - 1; i >= 0; i--)
        {
            for(int j = maze[0].length - 1; j >= 0; j--)
            {
                if(i+1 == maze.length && j+1 == maze[0].length)
                {
                    t[i][j] = maze[i][j];
                }
                else if(i+1 == maze.length)
                {
                    t[i][j] = maze[i][j] + t[i][j+1];
                }
                else if(j+1 == maze[0].length)
                {
                    t[i][j] = maze[i][j] + t[i+1][j];
                }
                else 
                {
                    if(t[i+1][j] < t[i][j+1])
                        t[i][j] = maze[i][j] + t[i+1][j];
                    else
                        t[i][j] = maze[i][j] + t[i][j+1];
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        int[][] maze = {
            {1, 5, 1, 0, 3},
            {1, 4, 0, 2, 3},
            {4, 0, 1, 3, 2},
            {2, 4, 0, 4, 1},
            {1, 2, 3, 2, 0},
        };
        int[][] t = new int[maze.length][maze[0].length];
        getCost(maze, t);
        bfs(t);
    }
}