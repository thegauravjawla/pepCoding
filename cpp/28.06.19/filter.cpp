#include <iostream>
#include <vector>
using namespace std;


void filter1(vector <int> &v)
{
    for(int i = v.size() - 1; i >= 0; i--)
    {
        if(v[i] > 50)
        {
            v.erase(v.begin() + i);
        }
    }
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
    cout << endl;
}

void filter2(vector <int>* v)
{
    for(int i = v->size() - 1; i >= 0; i--)
    {
        if(v->at(i) > 50)
        {
            v->erase(v->begin() + i);
        }
    }
    for (int i = 0; i < v->size(); i++)
    {
        cout << v->at(i) << " ";
    }
    cout << endl;
}

int main(int argc, char** argv)
{
    vector <int> v {25, 34, 64, 34, 74, 55, 50, 90, 82, 42};
    //first print
    filter1(v);
    //second print
    filter2(&v);
    
    //third print
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
}