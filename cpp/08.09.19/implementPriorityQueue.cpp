#include <bits/stdc++.h>
using namespace std;

class mypq{
    private:
    vector<int> list;
    bool less;

    //index is child
    void upHeapify(int index){
        if(index==0){
            return;
        }
        int parent = (index-1)/2;
        if(!isHigherPriority(parent, index)){
            swap(list[parent], list[index]);
            upHeapify(parent);
        }
    }

    //index is parent
    void downHeapify(int index){

        int left = 2*index+1;
        int right = 2*index+2;

        int highPriority = index;
        if(left < list.size() && !isHigherPriority(highPriority, left)){
            highPriority = left;
        }

        if(right < list.size() && !isHigherPriority(highPriority, right)){
            highPriority = right;
        }

        if(highPriority != index){
            swap(list[highPriority], list[index]);
            downHeapify(highPriority);
        }
    }

    bool isHigherPriority(int i, int j){
        if(less)
            return list[i] > list[j];
        else
            return list[i] < list[j];
    }

    public:

    //constructor
    mypq(bool less = true){
        //is the pq implementing less? T/F
        this->less = less;
    }

    //constructor in O(n) from array
    mypq(bool less, vector<int>& data){
        this->less = less;

        for(int i = 0; i < data.size(); i++){
            list.push_back(data[i]);
        }

        //we dont need to downheapify the leafs, so starting from the first non leaf
        for(int i = list.size()/2 - 1; i>=0; i--){
            downHeapify(i);
        }
    }

    void push(int val){
        list.push_back(val);
        upHeapify(list.size()-1);
    }

    void pop(){
        swap(list[0], list[list.size()-1]);
        list.pop_back();
        downHeapify(0);
    }

    int top(){
        return list[0];
    }

    int size(){
        return list.size();
    }
};

int main(int argc, char** argv){
    // mypq pq;
    // pq.push(10);
    // pq.push(20);
    // pq.push(500);
    // pq.push(30);
    // pq.push(40);
    // pq.push(60);

    //cool constructor
    vector<int> v {1, 5, 32, 532, 4, 85, 7, 22, 3};
    mypq pq(true, v); //important

    while(pq.size() > 0){
        int top = pq.top();
        pq.pop();
        cout << top << " ";
    }
    cout << endl;
}