#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector <string> getPath(int n)
{
    //base case for zero
    if(n == 0)
    {
        vector<string> stay;
        stay.push_back("");
        return stay;
    }
    else if(n < 0)  //dont run for n negative
    {
        vector<string> noPath;
        return noPath;
    }
    //
    vector <string> allPaths;   //answer
    for(int step = 1; step <= 3; step++)    //go these amount of step down
    {
        int nextInput = n - step;   //current step
        vector<string> faith = getPath(nextInput);  //get the steps to go from input step to zero
        for(int i = 0; i < faith.size(); i++)
        {
            string shortPath = faith[i];
            allPaths.push_back(to_string(step) + shortPath);
        }
    }
    return allPaths;
}

int main(int argc, char** argv)
{
    int n;
    cin >> n;
    vector <string> paths = getPath(n);
    for(int i = 0; i < paths.size(); i++)
    {
        cout << paths[i] << endl;
    }
}