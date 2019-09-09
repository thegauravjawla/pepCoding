#include<bits/stdc++.h>
using namespace std;

class median_priority_queue{
    priority_queue<int> left;
    priority_queue<int, vector<int>, greater<int>> right;

    void balance(){
        if(left.size()-right.size() == 2){
            int val = left.top();
            left.pop();
            right.push(val);
        }
        else if(right.size()-left.size() == 2){
            int val = right.top();
            right.pop();
            left.push(val);
        }
    }

    public:
    void push(int val){
        if(right.size() != 0 && val > right.top()){
            right.push(val);
        }
        else{
            left.push(val);
        }
        balance();
    }

    void pop(){
        if(right.size() > left.size()){
            right.pop();
        }
        else{
            left.pop();
        }
    }

    int top(){
        if(right.size() > left.size()){
            return right.top();
        }
        else{
            return left.top();
        }
    }

    int size(){
        return left.size() + right.size();
    }
};

int main(int argc, char** argv){
    median_priority_queue pq;

    pq.push(20);
    pq.push(5);
    pq.push(3);
    pq.push(17);
    pq.push(8);
    cout << pq.top() << " ";
    pq.push(9);
    pq.push(19);
    cout << pq.top() << " ";
    pq.push(11);
    cout << pq.top() << " ";
    pq.pop();
    pq.push(15);
    cout << pq.top() << " ";
    pq.pop();
    pq.push(77);
    pq.push(32);
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
    cout << pq.top() << " ";
    pq.pop();
}

//output -> 8 9 9 11 17 15 19 8 20 5 32 3 77