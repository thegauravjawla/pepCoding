#include <bits/stdc++.h>
using namespace std;

void downHeapify(vector<int>& v, int index, int lastIndex){
    int left = 2*index+1;
    int right = 2*index+2;

    int highPriority = index;
    if(left <= lastIndex && v[left] > v[highPriority]){
        highPriority = left;
    }

    if(right <= lastIndex && v[right] > v[highPriority]){
        highPriority = right;
    }

    if(highPriority != index){
        swap(v[highPriority], v[index]);
        downHeapify(v, highPriority, lastIndex);
    }
}

void heapSort(vector<int>& v){
    //down-heapifying the whole array, i.e creating the heap!! :D
    for(int i = v.size()/2 - 1; i>=0; i--){
        downHeapify(v, i, v.size()-1);
    }

    for(int i = 1; i < v.size(); i++){
        //swap the first and the local-last element
        swap(v[0], v[v.size() - i]);
        //down-heapifying the first element, because it is at a wrong location now
        downHeapify(v, 0, v.size()-i-1);
    }
}

int main(int argc, char** argv){
    vector<int> v {32, 19, 44, 66, 7, 2, 92};
    heapSort(v);

    for(int i = 0; i < v.size(); i++){
        cout << v[i] << " ";
    }
    cout << endl;
}