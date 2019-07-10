#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{
    int a, b;
    cin >> a >> b;

    if(a < b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    int sum = 0;
    int digit;
    int ten = 1;
    int carry = 0;
    for(int i = 0; a != 0; i++)
    {
        digit = a % 10;
        a = a/10;
        digit+= b%10;
        b = b/10;
        digit += carry;
        carry = 0;
        if(digit > 7)
        {
            digit -= 8;
            carry = 1;
        }
        sum += digit*ten;
        ten = ten*10;
    }
    sum += carry*ten;
    cout << sum;
}