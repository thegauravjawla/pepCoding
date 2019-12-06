#include <bits/stdc++.h>
using namespace std;

bool checkBalancedBracket(string s){
    stack<char> st;
    for(int i = 0; i < s.size(); i++){
        char ch = s[i];
        if(ch == '{'||ch == '('||ch == '['){
            st.push(ch);
        }
        if(ch == ')'){
            if(st.size() == 0)
                return false;
            else if(st.top() == '(')
                st.pop();
            else
                return false;
        }
        if(ch == ']'){
            if(st.size() == 0)
                return false;
            else if(st.top() == '[')
                st.pop();
            else
                return false;
        }
        if(ch == '}'){
            if(st.size() == 0)
                return false;
            else if(st.top() == '{')
                st.pop();
            else
                return false;
        }
    }
    if(st.size() != 0){
        return false;
    }
    return true;
}

int main(int argc, char** argv){
    cout << checkBalancedBracket("[a+{b+(d+e)}]") << endl;
    cout << checkBalancedBracket("[a+{b+(d+e})]") << endl;
    cout << checkBalancedBracket("a+{b+(d+e)}]") << endl;
    cout << checkBalancedBracket("[a+{b+(d+e)}") << endl;
}