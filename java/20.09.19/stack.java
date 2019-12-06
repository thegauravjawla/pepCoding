import java.util.*;
public class stack{
    private int top;
    private int[] stack;

    stack(){
        stack = new int[5];
        top = -1;
    }

    int size(){
        return top+1;
    }

    int top(){
        if(top == -1){
            System.out.println("Empty Stack");
            return -1;
        }
        return stack[top];
    }

    void pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return;
        }
        stack[top] = 0; //flushing value
        top--;
    }

    void push(int data){
        if(top == stack.length-1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = data;
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        while(s.size() > 0){
            System.out.print(s.top() + " ");
            s.pop();
        }
        System.out.println();

        System.out.println(s.top() + " ");
        s.pop();
    }
}