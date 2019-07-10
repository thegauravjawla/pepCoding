#include <iostream>
#include <vector>
using namespace std;

//function to check odd nature of the function
bool odd(int n)
{
    if(n%2 == 1)
        return true;
    else
        return false;
}

//function to check odd-ness and then return a vector of odd numbers
vector <int> check(int n)
{
    vector <int> v;
    int num;
    for(int i = 0; i < n; i++)
    {
        cin >> num;
        bool flag = odd(num);
        if(flag == true)
        {
            v.push_back(num);
        }
    }
    return v;
}

//main function
int main(int argc, char** argv)
{
    int n;
    cin >> n;

    //store the vector that the function return
    vector <int> v = check(n);
    
    //display
    for(int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
}