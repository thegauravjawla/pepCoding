import java.util.*;
public class knight
{
    static int counter = 0;
    public static void move(int r, int c, int[][] visited, int count)
    {
        if(r<0 || c<0 || r>=visited.length || c>=visited.length || visited[r][c] != 0)
        {
            return;
        }
        else if(count == visited.length * visited.length)
        {
            counter++;
            visited[r][c] = count;
            System.out.println("********" + counter + "********");
            for(int i = 0; i < visited.length; i++)
            {
                for(int j = 0; j < visited[0].length; j++)
                {
                    System.out.print(visited[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("********" + counter + "********");

            visited[r][c] = 0;
        }
        visited[r][c] = count;
        move(r+2, c+1, visited, count + 1);
        move(r+1, c+2, visited, count + 1);
        move(r+2, c-1, visited, count + 1);
        move(r+1, c-2, visited, count + 1);
        move(r-2, c+1, visited, count + 1);
        move(r-1, c+2, visited, count + 1);
        move(r-2, c-1, visited, count + 1);
        move(r-1, c-2, visited, count + 1);
        visited[r][c] = 0;
        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //dimension of chess
        //position of knight
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] visited = new int[n][n];
        move(r, c, visited, 1);
    }
}