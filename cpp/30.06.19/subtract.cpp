#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{
    int a, b;
    cin >> a >> b;

    int t = a;
    bool flag = 0;
    if(a < b)
    {
        flag = 1;
        t = b;
        int temp = a;
        a = b;
        b = temp;
    }

    int sum = 0;
    int digit;
    int ten = 1;
    int carry = 0;
    for(int i = 0; t != 0; i++)
    {
        t = t/10;
        digit = a % 10;
        digit = digit - carry;
        carry = 0;
        a = a/10;
        digit = digit - b%10;
        b = b/10;

        // digit+= carry;
        // carry = 0;
        if(digit < 0)
        {
            digit+=8;
            carry = 1;
        }
        // if(digit > 7)
        // {
        //     digit -= 8;
        //     carry = 1;
        // }
        sum += digit*ten;
        ten = ten*10;
    }
    sum = sum - carry*ten;    
    if(flag)
    {
        sum = (-1) * sum;
    }    
    cout << sum;
}