#include <iostream>
#include<string>
#include<vector>
#include <unordered_set>
using namespace std;

void breakTheString(unordered_set<string>& dictionary, string Q, string ans)
{
    if(Q.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    for(int i = 1; i <= Q.length(); i++)
    {
        string pre = Q.substr(0, i);
        if(dictionary.count(pre))
        {
            string post = Q.substr(i, Q.length() - i);
            breakTheString(dictionary, post, ans + "-" + pre);
        }
    }
    return;
}

int main(int argc, char** argv)
{
    unordered_set<string> dictionary;
    //test case 1
    // dictionary.insert("like");
    // dictionary.insert("sung");
    // dictionary.insert("go");
    // dictionary.insert("man");
    // dictionary.insert("mango");
    // dictionary.insert("sam");
    // dictionary.insert("samsung");
    // dictionary.insert("i");
    // string Q = "ilikesamsungmango";

    //test case 2
    dictionary.insert("man");
    dictionary.insert("go");
    dictionary.insert("mango");
    dictionary.insert("ice");
    dictionary.insert("icecream");
    dictionary.insert("cream");
    dictionary.insert("sam");
    dictionary.insert("sung");
    dictionary.insert("samsung");
    string Q = "mangoicecreamsamsung";
    breakTheString(dictionary, Q, "");
}