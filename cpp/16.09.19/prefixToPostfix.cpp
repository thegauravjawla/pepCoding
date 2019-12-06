#include<bits/stdc++.h>
using namespace std;

void preToPost(string exp){
    stack<string> post;

    for(int i = exp.length()-1; i>=0; i--){
        char ch = exp[i];

        if(ch>='0' && ch<='9'){
            post.push(to_string(ch-'0'));
        }
        else{
            string a = post.top(); post.pop();
            string b = post.top(); post.pop();
            post.push(a + b + ch);
        }
    }
    cout << post.top() << endl;
}

int main(int argc, char** argv){
    preToPost("+8^3/4-31");
}