#include <iostream>
using namespace std;

void tower(int n, int st, int dt, int ht)
{
    if(n == 0)
    {
        return;
    }

    tower(n-1, st, ht, dt);
    cout << n << "[" << st << " - " << dt << "]" << endl;
    tower(n-1, ht, dt, st);
}

int main(int argc, char** argv)
{
    int n, st, dt, ht;
    cin >> n >> st >> dt>> ht;

    tower(n, st, dt, ht);
}