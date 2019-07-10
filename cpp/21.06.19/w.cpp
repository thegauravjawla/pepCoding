#include <iostream>
using namespace std;

int main(int argc, char** argv)
{
    int n;
    cin >> n;
    int nsp = n/2, nst = 1;
    int val;
    int ii = 1;
    for (int i = 1; i <= n; i++)
    {   
        for(int j = 0; j < nsp; j++)
        {
            cout << "  ";
        }
        val = ii;
        for(int j = 0; j < ; j++)
        {
            cout << val << " ";
            if(j < nst/2)
                val++;
            else
                val--;
        }
        if(i >= n/2)
        {
            nst -= 2;
            nsp++;
            ii--;
        }
        else
        {
            nst += 2;
            nsp--;
            ii++;
        }
        cout << endl;
    }
}