#include <bits/stdc++.h>
using namespace std;

//forward traversal
int* getArray(int*& a, int n){
    int* b = new int[n];
    stack<int> st;

    for(int i = 0; i < n; i++){
        while(st.size() > 0 && a[i] > a[st.top()]){
            b[st.top()] = a[i];
            st.pop();
        }
        st.push(i);
    }

    while(st.size() > 0){
        b[st.top()] = -1;
        st.pop();
    }

    return b;
}

//reverse traversal
int* getArray2(int*& a, int n){
    int* b = new int[n];
    stack<int> st;
    st.push(a[n-1]);
    b[n-1] = -1;

    for(int i = n-2; i>=0; i--){
        //deleting all the smaller elements, because the are useless now
        while(st.size() > 0 && a[i] > st.top()){
            st.pop();
        }
        b[i] = st.size()==0?-1:st.top();
        st.push(a[i]);
    }

    return b;
}

int main(int argc, char** argv){
    int n;
    cin >> n;
    int* a = new int[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    int* b = getArray(a, n);
    for(int i = 0; i < n; i++){
        cout << b[i] << " ";
    }
    cout << endl;

    b = getArray2(a, n);
    for(int i = 0; i < n; i++){
        cout << b[i] << " ";
    }
    cout << endl;
}
//input-> 5 9 8 3 2 7 16 4 14 19 3
