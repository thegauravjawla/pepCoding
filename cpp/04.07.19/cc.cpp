#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void add(int* a, int* b, int n, int m)
{
    vector <int> s;
    int sum = 0;
    int carry = 0;
    while(n >= 0 || m >= 0)
    {
        sum = carry;
        carry = 0;
        if(n >= 0)
        {
            sum+= a[n];
        }
        if(m >= 0)
        {
            sum+= b[m];
        }
        if(sum > 9)
        {
            sum = sum - 10;
            carry++;
        }
        s.push_back(sum);
        n--;
        m--;
    }
    for(int i = s.size() - 1; i >= 0; i--)
    {
        cout << s[i] << " ";
    }
}

int main() 
{
    //all inputs
    int n;
    cin >> n;
    int* a = new int[n];
    for (int i=0; i < n; i++)
    {
        cin >> a[i];
    }
    int m;
    cin >> m;
    int* b = new int[m];
    for (int i = 0; i < m; i++)
    {
        cin >> b[i];
    }
    //
    add(a, b, n - 1, m - 1);
}
