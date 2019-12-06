#include<bits/stdc++.h>
using namespace std;

int* maxArray(int* a, int n){
    int* res = new int[n];
    stack<int> st;
    res[n-1] = n;
    st.push(n-1);
    for(int i = n-2; i>=0; i--){
        while(st.size() > 0 && a[st.top()] < a[i]){
            st.pop();
        }
        res[i] = st.size()==0?n:st.top();
        st.push(i);
    }

    return res;
}

int* maxInWindow(int* a, int n, int k){
    int* right = maxArray(a, n);
    int i = 0;
    int j = 0;
    
    int* ans = new int[n-k+1];
    for(int i = 0; i < n-k+1; i++){
        if(i > j){
            j = i;
        }

        while(right[j] < i + k){
            j = right[j];
        }

        ans[i] = a[j];
    }
    return ans;
}

int main(int argc, char** argv){
    int n;
    cin >> n;
    int* a = new int[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    int k;
    cin >> k;
    int* max = maxInWindow(a, n, k);
    for(int i = 0; i < n-k+1; i++){
        cout << max[i] << " ";
    }
    cout << endl;
}
