#include<bits/stdc++.h>
using namespace std;

int priority(char op){
    switch(op){
        case '+':
        case '-':
            return 0;
            break;
        case '*':
        case '/':
        case '%':
            return 1;
            break;
        case '^':
            return 2;
            break;
        default:
            break;
    }
}

void infixTopre(string exp){
    stack<string> pre; //for value
    stack<char> os;    //for operation

    for(int i = 0; i < exp.length(); i++){
        char ch = exp[i];
        if(ch >= '0' && ch <= '9'){
            pre.push(to_string(ch - '0'));
        }
        else if(ch == '('){
            os.push(ch);
        }
        else if(ch == ')'){
            while(os.top() != '('){
                string b = pre.top(); pre.pop();
                string a = pre.top(); pre.pop();
                char op = os.top(); os.pop();
                pre.push(op+a+b);
            }
            os.pop();
        }
        else{
            while(os.size() > 0 && os.top() != '(' && priority(os.top()) >= priority(ch)){
                string b = pre.top(); pre.pop();
                string a = pre.top(); pre.pop();
                char op = os.top(); os.pop();
                pre.push(op+a+b);
            }
            os.push(ch);
        }
    }
    while(os.size() != 0){
        string b = pre.top(); pre.pop();
        string a = pre.top(); pre.pop();
        char op = os.top(); os.pop();
        pre.push(op+a+b);
    }
    cout << pre.top();
}

int main(int argc, char** argv){
    infixTopre("8+3^(4/(3-1))");
}