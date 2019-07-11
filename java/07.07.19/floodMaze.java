import java.util.*;
public class floodMaze
{
    static void getPath(int sr, int sc, int[][] maze, String ans)
    {
        if(sr == maze.length - 1 && sc == maze[0].length - 1)
        {
            System.out.println(ans);
            return;
        }

        maze[sr][sc] = 1;
        if(sr > 0 && maze[sr-1][sc] == 0)
        {
            getPath(sr-1, sc, maze, ans + 'T');
        }
        if(sc > 0 && maze[sr][sc-1] == 0)
        {
            getPath(sr, sc-1, maze, ans + 'L');
        }
        if(sr < maze.length - 1 && maze[sr+1][sc] == 0)
        {
            getPath(sr+1, sc, maze, ans + 'D');
        }
        if(sc < maze[0].length - 1 && maze[sr][sc+1] == 0)
        {
            getPath(sr, sc+1, maze, ans + 'R');
        }

        maze[sr][sc] = 0;
        return;
    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] maze = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                maze[i][j] = scn.nextInt();
            }
        }
        getPath(0, 0, maze, "");
    }
}
