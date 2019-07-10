#include <iostream>
using namespace std;

void increasingOrder(int n)
{
    if(n == 0)
        return;

increasingOrder(n-1);
    cout << n;
}

int main(int argc, char** argv)
{
    int n;
    cin >> n;

    increasingOrder(n);
}