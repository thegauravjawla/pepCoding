#include<iostream>
using namespace std;

//Swap Function
void swap(int* arr, int l, int r)
{
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
}

//Reverse of array function
void reverse(int* arr, int n)
{
    int l = 0;
    int r = n - 1;
    while(l < r)
    {
        swap(arr, l, r);
        l++;
        r--;
    }
}

//print function
void display(int* arr, int n)
{
    for(int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

//main function
int main(int argc, char** argv)
{
    int n;
    cin >> n;
    int* arr = new int[n];  //Dynamic array allocation
    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    reverse(arr, n);
    display(arr, n);
}