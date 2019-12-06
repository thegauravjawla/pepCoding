#include <bits/stdc++.h>
using namespace std;

class Interval{
    public:
    int s;
    int e;

    Interval(){}
    Interval(int s, int e){
        this->s = s;
        this->e = e;
    }

    bool operator<(const Interval other)const{
        return this->s < other.s;
    }
};

void mergeIntervals(vector<int> start, vector<int> end){
    vector<Interval> v;
    for(int i = 0; i < start.size(); i++){
        Interval temp(start[i], end[i]);
        v.push_back(temp);
    }

    sort(v.begin(), v.end());

    stack<Interval> s;
    s.push(v.at(0));

    for(int i = 1; i < start.size(); i++){
        if(v[i].s < s.top().e){
            s.top().e = max(s.top().e, v[i].e);
        }
        else{
            s.push(v[i]);
        }
    }

    while(s.size() > 0){
        cout << s.top().s << " - " << s.top().e << endl;
        s.pop();
    }
}

int main(int argc, char** argv){
    vector<int> start = {1, 6, 5, 2};
    vector<int> end = {3, 8, 7, 4};

    mergeIntervals(start, end);
}