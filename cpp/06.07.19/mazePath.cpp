#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<string> getPath(int startRow, int startCol, int endRow, int endCol) // endRow, endCol constant
{
    if(startRow == endRow && startCol == endCol)
    {
        vector<string> stay;
        stay.push_back("");
        return stay;
    }

    vector<string> allPath;
    vector<string> faith1, faith2;
    //horizontal move, row constant
    if(startCol < endCol)
    {
        int nextInputH = startCol + 1;
        faith1 = getPath(startRow, nextInputH, endRow, endCol);
    }
    for(int i = 0; i < faith1.size(); i++)
    {
        string shortPath = "H" + faith1[i];
        allPath.push_back(shortPath);
    }

    //vertical move, 
    if(startRow < endRow)
    {
        int nextInputV = startRow + 1;
        faith2 = getPath(nextInputV, startCol, endRow, endCol);
    }

    for(int i = 0; i < faith2.size(); i++)
    {
        string shortPath = "V" + faith2[i];
        allPath.push_back(shortPath);
    }
    return allPath;
}

int main(int argc, char** argv)
{
    int m, n;
    cin >> m >> n;

    vector<string> paths = getPath(0, 0, m-1, n-1);
    for(int i = 0; i < paths.size(); i++)
    {
        cout << paths[i] << endl;
    }
}