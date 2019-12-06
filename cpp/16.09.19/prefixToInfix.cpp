#include<bits/stdc++.h>
using namespace std;

void preToIn(string exp){
    stack<string> in;

    for(int i = exp.length()-1; i>=0; i--){
        char ch = exp[i];

        if(ch>='0' && ch<='9'){
            in.push(to_string(ch-'0'));
        }
        else{
            string a = in.top(); in.pop();
            string b = in.top(); in.pop();
            in.push("(" + a + ch + b + ")");
        }
    }
    cout << in.top() << endl;
}

int main(int argc, char** argv){
    preToIn("+8^3/4-31");
}