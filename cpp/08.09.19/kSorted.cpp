#include<bits/stdc++.h>
using namespace std;

void sort(vector<int>& v, int k){
    priority_queue<int, vector<int>, greater<int>> pq;

    for(int i = 0; i < k+1; i++){
        pq.push(v[i]);
    }

    for(int i = k+1; i < v.size(); i++){
        int top = pq.top();
        pq.pop();
        cout << top << " ";
        pq.push(v[i]);
    }

    while(pq.size() > 0){
        int top = pq.top();
        pq.pop();
        cout << top << " ";
    }

    cout << endl;
}

int main(int argc, char** argv){
    vector<int> v {5, 14, 2, 8, 15, 25, 35, 20, 40, 50, 42};
    int k = 2;

    sort(v, k);
}