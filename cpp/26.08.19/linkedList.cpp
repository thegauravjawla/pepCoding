#include <bits/stdc++.h>
using namespace std;

class Node
{
    public:
        int data;
        Node* next;
    
    Node()
    {
        this->data = 0;
        this->next = NULL;
    }
    Node(int data, Node* next)
    {
        this->data = data;
        this->next = next;
    }
};

void addLast(Node*& head, Node*& tail, int data)
{
    if(head == NULL)
    {
        head = tail = new Node(data, NULL);
        return;
    }
    Node* node = new Node(data, NULL);
    tail->next = node;
    tail = node;
}

void display(Node* head)
{
    for(Node* ith = head; ith != NULL; ith = ith->next)
    {
        cout << ith->data << " ";
    }
    cout << endl;
}

int main(int argc, char** argv)
{
    Node* head = NULL;
    Node* tail = NULL;

    addLast(head, tail, 10);
    addLast(head, tail, 20);
    addLast(head, tail, 30);
    addLast(head, tail, 40);
    addLast(head, tail, 50);

    display(head);
}
