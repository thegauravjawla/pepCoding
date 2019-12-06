#include <bits/stdc++.h>
using namespace std;

int* smallerOnLeft(int* a, int n){
    stack<int> st;
    int* left = new int[n];
    left[0] = -1;
    st.push(0);
    for(int i = 1; i < n; i++){
        while(st.size() > 0 && a[st.top()] > a[i]){
            st.pop();
        }
        left[i] = st.size()==0?-1:st.top();
        st.push(i);
    }

    return left;
}

int* smallerOnRight(int* a, int n){
    stack<int> st;
    int* right = new int[n];
    right[n-1] = n;
    st.push(n-1);

    for(int i = n-2; i>=0; i--){
        while(st.size() > 0 && a[st.top()] > a[i]){
            st.pop();
        }
        right[i] = st.size()==0?n:st.top();
        st.push(i);
    }
    return right;
}

int maxArea(int*& a, int n){
    int* left = smallerOnLeft(a, n); //array of indices
    int* right = smallerOnRight(a, n);

    int max = 0;

    for(int i = 0; i < n; i++){
        int width = right[i] - left[i] - 1;
        int height = a[i];
        int area = width*height;
        if(area > max){
            max = area;
        }
    }
    return max;
}

int main(int argc, char** argv){
    int n;
    cin >> n;
    int* a = new int[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    int max = maxArea(a, n);
    cout << max << endl;
}

//represents the heights of different columns of histogram
//input-> 6 2 5 4 5 1 6
