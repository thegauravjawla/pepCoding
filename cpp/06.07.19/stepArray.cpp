#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector <string> getPath(int* a, int n, int index)
{
    if(index == n - 1)
    {
        vector<string> stay;
        stay.push_back("");
        return stay;
    }
    else if (index >= n)
    {
        vector<string> nothing;
        return nothing;
    }

    vector <string> allPath;
    for(int step = 1; step <= a[index]; step++)
    {
        vector<string> faith = getPath(a, n, index + step);
        for(int i = 0; i < faith.size(); i++)
        {
            allPath.push_back(to_string(step) + faith[i]);
        }
    }
    return allPath;
}

int main(int argc, char** argv)
{
    int n;
    cin >> n;
    int* a = new int[n];
    for(int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    vector <string> paths = getPath(a, n, 0);
    for(int i = 0; i < paths.size(); i++)
    {
        cout << paths[i] << endl;
    }
}