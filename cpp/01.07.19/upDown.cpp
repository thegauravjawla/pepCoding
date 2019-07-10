#include <iostream>
using namespace std;

void decInc(int n)
{
    if(n == 0)
        return;

    cout << n;  //pre region
    decInc(n-1);
    cout << n;  //post region
}

int main(int argc, char** argv)
{
    int n;
    cin >> n;

    decInc(n);
}