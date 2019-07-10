#include <iostream>

using namespace std;

int power(int x, int n)
{
    if(n == 0)
        return 1;
    int p = x*power(x, n-1);
    return p;
}

int main(int argc, char** argv)
{
    int x, n;
    cin >> x >> n;
    cout << power(x, n);
}