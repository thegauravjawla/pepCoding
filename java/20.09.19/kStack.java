import java.util.*;
public class kStack{
    private int[] data;
    private int[] next;
    private int[] head;
    private int free;

    kStack(int k, int capacity){
        data = new int[capacity];
        next = new int[capacity];
        head = new int[k];
        free = 0;

        //all point to the next element
        for(int i = 0; i < capacity-1; i++){
            next[i] = i+1;
        }
        next[capacity-1] = -1;

        //all stacks are empty, hence their head is null
        Arrays.fill(head, -1);
    }

    boolean isFull(){
        return free == -1;
    }

    //checking ith stack for empty
    boolean isEmpty(int i){
        return head[i] == -1;
    }

    //use operations similar to linked list (on head only)!!! :D

    int top(int i){
        if(isEmpty(i)){
            System.out.println("Stack is Empty");
            return -1;
        }
        return data[head[i]];
    }

    void pop(int i){
        if(isEmpty(i)){
            System.out.println("Stack Underflow");
            return;
        }
        int temp = head[i];
        head[i] = next[head[i]];

        next[temp] = free;
        free = temp;
    }

    void push(int i, int val){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        
        int temp = free;
        free = next[free];

        if(isEmpty(i)){
            data[temp] = val;
            next[temp] = -1;
            head[i] = temp;
        }
        else{
            data[temp] = val;
            next[temp] = head[i];
            head[i] = temp;
        }
    }

    public static void main(String[] args) {
        kStack s = new kStack(4, 12);

        s.push(0, 10);
        s.push(1, 20);
        s.push(2, 30);
        s.push(2, 80);
        s.pop(1);
        s.push(3, 40);
        s.push(3, 50);
        s.pop(3);
        s.push(2, 70);
        s.push(1, 90);
        s.push(0, 100);
        s.push(1, 110);
        s.push(2, 120);
        s.push(3, 60);
        s.push(2, 130);
        s.push(1, 140);


        for(int i = 0; i < 4; i++){
            while(!s.isEmpty(i)){
                System.out.print(s.top(i) + " ");
                s.pop(i);
            }
            System.out.println();
        }
    }
}

//output:-
// 100 10
// 140 110 90
// 130 120 70 80 30
// 60 40