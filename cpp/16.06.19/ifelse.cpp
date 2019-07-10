#include <iostream>
using namespace std;

int main(int argc, char** argv)
{
    int e1s = 0;
    int e1e = 100; 
    int e2s = 14;
    int e2e = 18;
    if (e1e < e2s || e2e < e1s)
    {
        cout << "No Overlap" << endl;
    }
    else
    {
        if ((e2s > e1s && e2e < e1e) || (e1s > e2s && e1e < e2e))
        {
            cout << "Full Overlap"<< endl;
        }
        else
        {
            cout << "Partial Overlap" << endl;
        }
        
    }
}
// Reviewed by Amrit