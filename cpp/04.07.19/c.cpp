#include <iostream>
#include <vector>
#include <string>
#include <string.h>
using namespace std;

vector<string> codes = {".", "abc", "def", "gh", "jkl", "mno", "pqrs", "tuv", "wx", "yz"};

int keyPad(string str, string ans) 
{
    if(str.empty())
    {
        cout << ans << endl;
        return 1;
    }
    int temp = 0;
    for(int i = 0; i < codes[str.at(0) - '0'].size(); i++)
    {
        cout << ans;
        if(str.size() == 1)
            temp = temp + keyPad("", (codes[str.at(0) - '0']).substr(i, 1));
        else temp = temp + keyPad(str.substr(1, str.size()), (codes[(str.substr(0, str.size())).at(0) - '0']).substr(i, 1);
    }
    return temp;
}

//Driver program
int main(int argc, char** argv){
        string s;
        cin >> s;

        int ans = keyPad(s, "");
        cout << ans << endl;   
}