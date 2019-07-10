#include <iostream>
#include <vector>
#include <cmath>
#include <cstdio>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{
    int* digits = new int[36];
    for(int i = 0; i < 10; i++)
    {
        digits[i] = i;
    }
    for(int i = 10; i < 37; i++)
    {
        digits[i] = 55 + i;
    }
    int n, base, newBase;
    cin >> n >> base >> newBase;
    int d = 0;
    int temp, val = 0;
    for(int i = 0; n != 0; i++)
    {
        temp = pow(base, i);
        d = n%10;
        n = n/10;
        val += d*temp;
    }
    int p = 0;
    int ans = 0;
    int k = 0;
    while(val != 0)
    {   
        if(val < pow(newBase, p))
        {
            val = val - pow(newBase, p-1);
            if(p-1 > 10){
                char x = digits[p-1];
                cout << x;
                }
                else
                cout << p-1;
            p = -1;
        }
        
        
        p++;
    }
    cout << ans << endl;
}