#include<iostream>
#include<string>
#include<vector>

using namespace std;

void encoding(string Q, string ans)
{
    if(Q.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    else if(Q.length() == 1)
    {
        char first = (Q[0] - '0' - 1) + 'a';
        string nextInput = "";
        encoding(nextInput, ans + first);
    }
    else
    {
        char first = (Q[0] - '0' - 1) + 'a';
        string nextInput = Q.substr(1, Q.length() - 1);
        if(first != '`')    //if first number is not zero
        {
            //for 1 number
            encoding(nextInput, ans + first);
        
            //for 2 numbers
            char twoDigit = ((Q[0] - '0') * 10 + (Q[1] - '0') - 1) + 'a';
            nextInput = Q.substr(2, Q.length() - 2);
            if(twoDigit >= 'a' && twoDigit <= 'z')
            {
                encoding(nextInput, ans + twoDigit);
            }
        }
    }
    return;
}

int main(int argc, char** argv)
{
    encoding("1123", "");
    cout << "----------" << endl;
    encoding("1321", "");
    cout << "----------" << endl;
    encoding("1023", "");
}