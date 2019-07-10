#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
    int m;
    cin >> m;
    int* a = new int[m];
    for(int i = 0; i < m; i++)
    {
        cin >> a[i];
    }
    sort(a, a+m);

    int n;
    cin >> n;
    int* b = new int[n];
    for(int i = 0; i < n; i++)
    {
        cin >> b[i];
    }
    sort(b, b+n);

    int i = 0;  //pointing to the beginning of a
    int j = 0;  //pointing to the beginning of b

    while(i < m && j < n)
    {
        if(a[i] == b[j])
        {
            cout << a[i] << " ";
            i++;j++;
        }
        else if(a[i] > b[j])
        {
            j++;
        }
        else 
        {
            i++;
        }
    }
}