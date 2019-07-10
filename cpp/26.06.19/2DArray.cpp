#include <iostream>
using namespace std;

int ** takeInput(int r, int c)
{
    int ** a = new int*[r];
    for(int i = 0; i < r; i++)
    {
        a[i] = new int[c];
        for(int j = 0; j < c; j++)
        {
            cout << "a" << i << j <<"=";
            cin >> a[i][j];
        }
    }
    return a;
}

void display(int** a, int r, int c)
{
    for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
        {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main(int argc, char** argv)
{
    int r, c;
    cout << "r and c = ";
    cin >> r >> c;

    int ** a = takeInput(r, c);
    display(a, r, c);
}