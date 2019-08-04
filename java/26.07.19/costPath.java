import java.util.*;
public class costPath
{
    static void getPath(int[][] t, int i, int j, String ans)
    {
        if(i+1 == t.length && j+1 == t[0].length)
        {
            System.out.println(ans);
            return;
        }
        else if(i+1 == t.length)
        {
            getPath(t, i, j+1, ans + "H");
        }
        else if(j+1 == t[0].length)
        {
            getPath(t, i+1, j, ans + "V");
        }
        else
        {
            if(t[i+1][j] < t[i][j+1])
            {
                getPath(t, i+1, j, ans + "V");
            }
            else if(t[i+1][j] > t[i][j+1])
            {
                getPath(t, i, j+1, ans + "H");
            }
            else
            {
                getPath(t, i+1, j, ans + "V");
                getPath(t, i, j+1, ans + "H");
            }
        }
        return;
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
                else if(t[i+1][j] < t[i][j+1])
                {
                    t[i][j] = maze[i][j] + t[i+1][j];
                }
                else
                {
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
        getPath(t, 0, 0, "");
    }
}