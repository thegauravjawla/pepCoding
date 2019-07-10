#include <iostream>

using namespace std;

int power(int x, int n)
{
    if(n == 0)
        return 1;
    int powNby2 = power(x, n/2);
    int p = powNby2 * powNby2;  //in the case of 9(an odd number), it will return answer for 8,
    if(n%2 == 1)                //so, we multiply it by one more x in case of an odd number.
        p = p*x;
    return p;
}

int main(int argc, char** argv)
{
    int x, n;
    cin >> x >> n;
    cout << power(x, n);
}