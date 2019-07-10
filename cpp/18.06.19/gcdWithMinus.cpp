#include <iostream>
using namespace std;

int main(int argc, char** argv)
{
    int m, n;
    cin >> m >> n;
    int temp;
    for(int i = 0; true; i++)
    {
        if(m == n)
        {
            cout << m << endl;
            break;
        }
        else if(n < m)
        {
            temp = n;
            n = m;
            m = temp;
        }
        temp = n;
        n = n - m;
    }
}