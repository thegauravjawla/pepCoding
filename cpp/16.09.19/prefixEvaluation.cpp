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

int prefix(string exp){
    stack<int> val;

    //reverse loop
    for(int i = exp.length()-1; i>=0; i--){
        char ch = exp[i];

        if(ch>='0' && ch<='9'){
            val.push(ch-'0');
        }
        else{
            int a = val.top(); val.pop();
            int b = val.top(); val.pop();
            int value = getVal(a, b, ch);
            val.push(value);
        }
    }
    return val.top();
}

int main(int argc, char** argv){
    cout << prefix("+8^3/4-31") << endl;
}