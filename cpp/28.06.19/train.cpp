#include <iostream>
#include <vector>
using namespace std;

int main(int argc, char** argv)
{
    int n;
    cin >> n;
    
    //input of vector
    vector <int> v;
    int temp;
    for(int i = 0; i < n; i++)
    {
        cin >> temp;
        v.push_back(temp);
    }

    //window start, window end;
    int ws, we;
    cin >> ws >> we;
    
    for(int j = 0; j < n; j++)
    {
        for(int i = ws; i <= we; i++)
        {
            cout << v[i] << " ";
        }
        temp = v.back();
        v.pop_back();
        v.insert(v.begin(), temp);
        cout << endl;
    }
}