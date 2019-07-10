#include <iostream>
using namespace std;

//Recursive Function
void decreasingOrder(int n)
{
    if(n == 0)
        return;

    cout << n;
    decreasingOrder(n-1);
}

int main(int argc, char** argv)
{
    int n;
    cin >> n;

    decreasingOrder(n);
}