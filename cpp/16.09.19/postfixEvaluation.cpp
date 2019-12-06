#include<bits/stdc++.h>
using namespace std;

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

int postfix(string exp){
    stack<int> val;

    for(int i = 0; i < exp.length(); i++){
        char ch = exp[i];

        if(ch>='0' && ch<='9'){
            val.push(ch-'0');
        }
        else{
            int b = val.top(); val.pop();
            int a = val.top(); val.pop();
            int value = getVal(a, b, ch);
            val.push(value);
        }
    }
    return val.top();
}

int main(int argc, char** argv){
    cout << postfix("83431-/^+") << endl;
}