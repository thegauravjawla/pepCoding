#include <iostream>
using namespace std;

//read rotate
//then reverse
//then swap

//swap the two numbers from the address
void swap(int * a, int * b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

//reverse the input matrix from Lth to Rth index
void reverse(int * a, int l, int r)
{
    while(l < r)
    {
        swap(&a[l], &a[r]);
        l++;
        r--;
    }
}

//rotate the matrix as asked
void rotate(int * a, int n, int k)
{
    k = k % n;
    k = k < 0? n+k:k;
    reverse(a, 0, n-k-1);
    reverse(a, n-k, n-1);
    reverse(a, 0, n-1);
}

//print the array
void display(int * a, int n)
{
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
}

//this is a nesting thingy!

int main(int argc, char** argv)
{
    //input
    int n;
    cin >> n;
    int* a = new int[n];
    for(int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    int k;
    cin >> k;
    //
    
    rotate(a, n, k);
    display(a, n);
}