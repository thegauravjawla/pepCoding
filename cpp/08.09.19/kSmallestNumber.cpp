#include <bits/stdc++.h>
using namespace std;

void getKSmallest(vector<int>& v, int k){
    priority_queue<int> pq;
    pq.push(v[0]);
    for(int i = 1; i < v.size(); i++){
        if(pq.size() >= k){
            if(pq.top() > v[i]){
                pq.pop();
                pq.push(v[i]);
            }
        }
        else
            pq.push(v[i]);
    }

    for(int i = 0; i < k; i++){
        cout << pq.top() << " ";
        pq.pop();
    }
}

int main(int argc, char** argv){
    int n;
    cin >> n;
    vector<int> v;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        v.push_back(x);
    }
    int k;
    cin >> k;

    getKSmallest(v, k);
}