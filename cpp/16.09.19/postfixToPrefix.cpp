#include<bits/stdc++.h>
using namespace std;

void postToPre(string exp){
    stack<string> pre;

    for(int i = 0; i < exp.length(); i++){
        char ch = exp[i];

        if(ch>='0' && ch<='9'){
            pre.push(to_string(ch-'0'));
        }
        else{
            string b = pre.top(); pre.pop();
            string a = pre.top(); pre.pop();
            pre.push(ch + a + b);
        }
    }
    cout << pre.top() << endl;
}

int main(int argc, char** argv){
    postToPre("83431-/^+");
}