#include<bits/stdc++.h>
using namespace std;

bool checkDuplicateBracket(string s){
    stack<char> st;
    for(int i = 0; i < s.size(); i++){
        char ch = s[i];
        if(ch == ')'){
            if(st.top() == '('){
                return true;
            }
            while(st.top() != '('){
                st.pop();
            }
            st.pop();
            if(st.size() == 0){
                return false;
            }
        }
        else{
            st.push(ch);
        }
    }
}

int main(int argc, char** argv){
    cout << checkDuplicateBracket("(a+((b+c+(d+e))+c))") << endl;
}