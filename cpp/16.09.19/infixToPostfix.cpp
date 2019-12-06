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

void infixToPost(string exp){
    stack<string> post; //for value
    stack<char> os; //for operation

    for(int i = 0; i < exp.length(); i++){
        char ch = exp[i];
        if(ch >= '0' && ch <= '9'){
            post.push(to_string(ch - '0'));
        }
        else if(ch == '('){
            os.push(ch);
        }
        else if(ch == ')'){
            while(os.top() != '('){
                string b = post.top(); post.pop();
                string a = post.top(); post.pop();
                char op = os.top(); os.pop();
                post.push(a+b+op);
            }
            os.pop();
        }
        else{
            while(os.size() > 0 && os.top() != '(' && priority(os.top()) >= priority(ch)){
                string b = post.top(); post.pop();
                string a = post.top(); post.pop();
                char op = os.top(); os.pop();
                post.push(a+b+op);
            }
            os.push(ch);
        }
    }
    while(os.size() != 0){
        string b = post.top(); post.pop();
        string a = post.top(); post.pop();
        char op = os.top(); os.pop();
        post.push(a+b+op);
    }
    cout << post.top();
}

int main(int argc, char** argv){
    infixToPost("8+3^(4/(3-1))");
}