#include <iostream>
#include<string>
#include<vector>
using namespace std;

void mapAll(int* map, int n1, int n2, int sum, string ans)
{
    
}

int main(int argc, char** argv)
{
    string n1 = "send";
    string n2 = "more";
    string sum = "money";
    int* map = new int[26];
    for(int i = 0; i < 26; i++)
    {
        map[i] = -1;
    }
    mapAll(map, n1, n2, sum, "");
}