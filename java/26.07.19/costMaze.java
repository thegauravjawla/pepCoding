import java.util.*;
public class costMaze
{
    //always divide these kinda question into 4 regions!! 
    static int getCost(int[][] maze, int[][] t)
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
        return t[0][0];
    }
    public static void main(String[] args) 
    {
        int[][] maze = {
            {2, 7, 3, 8, 0, 3, 7},
            {4, 0, 1, 2, 4, 3, 4},
            {3, 8, 5, 9, 0, 8, 1},
            {1, 6, 0, 4, 5, 5, 2},
            {6, 2, 9, 5, 7, 0, 6},
            {0, 8, 7, 9, 6, 3, 0},
            {1, 3, 5, 0, 5, 1, 0},
        };
        int[][] t = new int[maze.length][maze[0].length];
        int ans = getCost(maze, t);
        System.out.println(ans);
    }
}