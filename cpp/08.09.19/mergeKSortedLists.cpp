#include<bits/stdc++.h>
using namespace std;

class Point{
    public:
    int listIndex;
    int index;
    int value;

    Point(int listIndex, int index, int value){
        this->listIndex = listIndex;
        this->index = index;
        this->value = value;
    }

    bool operator>(const Point& other) const{
        return this->value > other.value;
    }
};

//itta ganda tukka :D
vector<int> merge(vector<vector<int>>& kLists){
    priority_queue<Point, vector<Point>, greater<Point>> pq;
    vector<int> mergedList;

    for(int i = 0; i < kLists.size(); i++){
        Point p(i, 0, kLists[i][0]);
        pq.push(p);
    }

    while(pq.size() > 0){
        Point top = pq.top(); pq.pop();

        Point addToPQ(top.listIndex, top.index+1, kLists[top.listIndex][top.index+1]);
        
        if(kLists[top.listIndex].size() > addToPQ.index){
            pq.push(addToPQ);
        }
        mergedList.push_back(top.value);
    }

    return mergedList;
}

int main(int argc, char** argv){
    vector<vector<int>> kLists {
                                {2, 9, 19, 25, 35},
                                {1, 5, 7, 12},
                                {6, 14, 49, 54, 66, 77},
                                {4, 12, 20}
                                };

    vector<int> mergedList = merge(kLists);

    for(int i = 0; i < mergedList.size(); i++){
        cout << mergedList[i] << " ";
    }
}