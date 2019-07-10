#include <iostream>
using namespace std;

int main(int argc, char** argv)
{
    int n;
    cin >> n;
    int flag = 0;
    for (int i = 2; i < n; i++)
    {
        if(n%i == 0)
        {
            flag = 1;
        }
    }
    if(flag == 0)
        cout  << "Prime!";
    else
        cout << "Not Prime";
}