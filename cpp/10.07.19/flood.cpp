#include <iostream>
#include<vector>
#include<string>
using namespace std;

void getPath(int sr, int sc, vector<vector<int>>& maze, string& ans)
    {
        if(sr == maze.size() - 1 && sc == maze[0].size() - 1)
        {
            cout << ans << endl;
            return;
        }

        maze[sr][sc] = 1;
        if(sr > 0 && maze[sr-1][sc] == 0)
        {
            ans+="T";
            getPath(sr-1, sc, maze, ans);
            ans.erase(ans.length() - 1, 1);
        }
        if(sc > 0 && maze[sr][sc-1] == 0)
        {
            ans+="L";
            getPath(sr, sc-1, maze, ans);
            ans.erase(ans.length() - 1, 1);
        }
        if(sr < maze.size() - 1 && maze[sr+1][sc] == 0)
        {
            ans+="D";
            getPath(sr+1, sc, maze, ans);
            ans.erase(ans.length() - 1, 1);
        }
        if(sc < maze[0].size() - 1 && maze[sr][sc+1] == 0)
        {
            ans+="R";
            getPath(sr, sc+1, maze, ans);
            ans.erase(ans.length() - 1, 1);
        }

        maze[sr][sc] = 0;
        return;
    }

int main(int argc, char** argv)
{
    int m, n;
    cin >> m >> n;
    vector<vector<int>> maze;
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            int temp;
            cin >> temp;
            maze[i].push_back(temp);
        }
    }
    string ans = "";
    getPath(0, 0, maze, ans);
}