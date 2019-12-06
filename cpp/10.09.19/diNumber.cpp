#include<bits/stdc++.h>
using namespace std;

string getNumber(string s){
    string ans = "";
    stack<int> st;

    int count = 1;
    for(int i = 0; i <= s.size(); i++){
        st.push(count++);

        if(s[i] == 'i' || s.size() == i){
            while(st.size() > 0){
                ans+=to_string(st.top());
                st.pop();
            }
        }
    }
    return ans;
}

int main(int argc, char** argv){
    string s = "iiiiiiii";
    cout << getNumber(s) << endl;
}