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

void kthFromLast(Node* head, int k)
{
    Node* slow = head;
    Node* fast = head;
    while(fast->next!=NULL)
    {
        if(k-- <= 1)
            slow = slow->next;
        fast = fast->next;
    }
    cout << slow->data << endl;
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
    kthFromLast(head, 3);
}