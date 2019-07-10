#include <iostream>
using namespace std;

int factorial(int n)
{
    if(n == 1)
    {
        return 1;
    }
    int f = n*factorial(n-1);
    return f;
}

int main(int argc, char** argv)
{
    int n;
    cin >> n;

    cout << factorial(n);
}