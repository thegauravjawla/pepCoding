import java.util.*;
public class doubleStack{
    private int top1;
    private int top2;
    private int[] stack;
    doubleStack(){
        top1 = -1;
        top2 = 6;
        stack = new int[6];
    }
    
    boolean isFull(){
        if(top1+1 == top2){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isEmpty1(){
        if(top1 == -1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isEmpty2(){
        if(top2 == 6){
            return true;
        }
        else{
            return false;
        }
    }

    void pop1(){
        if(isEmpty1()){
            System.out.println("Stack Underflow");
        }
        else{
            stack[top1] = 0;
            top1--;
        }
    }

    void pop2(){
        if(isEmpty2()){
            System.out.println("Stack Underflow");
        }
        else{
            stack[top2] = 0;
            top2++;
        }
    }

    int top1(){
        if(isEmpty1()){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            return stack[top1];
        }
    }

    int top2(){
        if(isEmpty2()){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            return stack[top2];
        }
    }

    void push1(int data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        top1++;
        stack[top1] = data;
    }

    void push2(int data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        top2--;
        stack[top2] = data;
    }

    public static void main(String[] args) {
        doubleStack s = new doubleStack();

        s.push1(10);
        s.push1(20);
        s.push1(25);

        s.push2(30);
        s.push2(40);
        s.push2(50);
        s.push2(60);
        s.push2(60);

        System.out.println(s.top1());
        System.out.println(s.top2());

        s.pop1();
        s.pop2();

        System.out.println(s.top1());
        System.out.println(s.top2());
    }
}