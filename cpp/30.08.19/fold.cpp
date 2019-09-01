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

void addFirst(Node*& head, Node*& tail, int data)
{
    if(tail==NULL)
    {
        Node* node = new Node(data, NULL);
        head = node;
        tail = node;
        return;
    }
    Node* node = new Node(data, head);
    head = node;
}

Node* getNodeAt(Node* head, int index)
{
    Node* node = head;
    for(int i = 0; i < index; i++)
    {
        node = node->next;
    }
    return node;
}

void display(Node* head)
{
    for(Node* i = head; i != NULL; i = i->next)
    {
        cout<<i->data<<" ";
    }
    cout<<endl;
}

void fold(Node*& left, Node* right, int& size, int count, Node*& tail)
{
    if(right == NULL)
    {
        return;
    }

    size++;
    fold(left, right->next, size, count+1, tail);

    if(count > size/2)
    {
        Node* temp = left->next;
        left->next = right;
        right->next = temp;
        left = temp;
    }
    else if(count == size/2)
    {
        tail = left;
        tail->next = NULL;
    }
}

int main(int argc, char** argv)
{
    Node* head = NULL;
    Node* tail = NULL;

    addFirst(head, tail, 10);
    addFirst(head, tail, 20);
    addFirst(head, tail, 30);
    addFirst(head, tail, 40);
    addFirst(head, tail, 50);
    addFirst(head, tail, 60);
    addFirst(head, tail, 70);

    display(head);
    Node* left = head;
    Node* right = head;
    int size = 0, count = 0;
    fold(left, right, size, count, tail);
    display(head);
}