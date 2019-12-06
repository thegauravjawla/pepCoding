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

int getVal(int a, int b, char op){
    switch(op){
        case '+':
            return a+b;
            break;
        case '-':
            return a-b;
            break;
        case '*':
            return a*b;
            break;
        case '/':
            return a/b;
            break;
        case '%':
            return a%b;
            break;
        case '^':
            return pow(a, b);
            break;
        default:
            break;
    }
}

int infix(string exp){
    stack<int> vs; //for value
    stack<char> os; //for operation

    for(int i = 0; i < exp.length(); i++){
        char ch = exp[i];
        if(ch >= '0' && ch <= '9'){
            vs.push(ch-'0');
        }
        else if(ch == '('){
            os.push(ch);
        }
        else if(ch == ')'){
            while(os.top() != '('){
                int b = vs.top(); vs.pop();
                int a = vs.top(); vs.pop();
                char op = os.top(); os.pop();
                int val = getVal(a, b, op);
                vs.push(val);
            }
            os.pop(); //just to pop that opening bracket too
        }
        else{
            while(os.size() > 0 && os.top() != '(' && priority(os.top()) >= priority(ch)){
                int b = vs.top(); vs.pop();
                int a = vs.top(); vs.pop();
                char op = os.top(); os.pop();
                int val = getVal(a, b, op);
                vs.push(val);
            }
            os.push(ch);
        }
    }
    while(os.size() != 0){
        int b = vs.top(); vs.pop();
        int a = vs.top(); vs.pop();
        char op = os.top(); os.pop();
        int val = getVal(a, b, op);
        vs.push(val);
    }
    return vs.top();
}

int main(int argc, char** argv){
    cout << infix("8+3^(4/(3-1))") << endl;
}