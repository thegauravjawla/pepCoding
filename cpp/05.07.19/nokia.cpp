#include <iostream>
#include <String>
#include <Vector>

using namespace std;

string codes[10] = {".", "abc", "def", "ghi", "jklm", "no", "pqrs", "tu", "vwxy", "z"};

vector<string> pattern(string s)
{
    if(s.length() == 0)
    {
        vector<string> result;
        result.push_back("");
        return result;
    }
    
    char firstKey = s[0];
    string nextInput = s.substr(1, s.length() - 1);
    vector<string> smallerPattern = pattern(nextInput);
    vector<string> result;
    int code = firstKey - '0';
    for(int i = 0; i < codes[code].length(); i++)
    {
        char currentNumberAlphabet = codes[code][i];
        for(int j = 0; j < smallerPattern.size(); j++)
        {
            string elementOfSmallerPattern = smallerPattern[j];
            result.push_back(currentNumberAlphabet + elementOfSmallerPattern);
        }
    }
    return result;
}

int main(int argv, char** argc)
{
    string keys;
    cin >> keys;
    vector<string> ans = pattern(keys);
    for(int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << endl;
    }
}