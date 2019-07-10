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
    //horizontal
    for(int maxStepLen = 1; maxStepLen <= endCol - startCol; maxStepLen++)
    {
        vector<string> faith = getPath(startRow, startCol + maxStepLen, endRow, endCol);
        for(int i = 0; i < faith.size(); i++)
        {
            allPath.push_back("H" + to_string(maxStepLen) + faith[i]);
        }
    }

    //vertical
    for(int maxStepLen = 1; maxStepLen <= endRow - startRow; maxStepLen++)
    {
        vector<string> faith = getPath(startRow + maxStepLen, startCol, endRow, endCol);
        for(int i = 0; i < faith.size(); i++)
        {
            allPath.push_back("V" + to_string(maxStepLen) + faith[i]);
        }
    }

    //diagonal
    for(int maxStepLen = 1; (maxStepLen <= endCol - startCol) && (maxStepLen <= endRow - startRow); maxStepLen++)
    {
        vector<string> faith = getPath(startRow + maxStepLen, startCol + maxStepLen, endRow, endCol);
        for(int i = 0; i < faith.size(); i++)
        {
            allPath.push_back("D" + to_string(maxStepLen) + faith[i]);
        }
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
    cout << paths.size();
}