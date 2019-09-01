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

void removeFirst(Node*& head, Node*& tail)
{
    Node* del = head;
    if(head == tail)
        head = tail = NULL;
    else
        head = head->next;
    delete del;
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

int sizeOf(Node* head)
{
    int count = 0;
    while(head != NULL)
    {
        head = head->next;
        count++;
    }
    return count;
}

Node* hasCycle(Node* head)
{
    Node* fast = head;
    Node* slow = head;
    Node* k = NULL;

    while(fast->next != NULL)
    {
        fast = fast->next->next;
        slow = slow->next;
        if(fast == slow)
        {
            k = fast;
            return k;
        }
    }
    return k;
}

void removeCycle(Node*& head, Node*& tail)
{
    Node* fromHead = head;
    Node* fromK = hasCycle(head);
    if(fromK == head)
    {
        while(fromHead->next != head)
        {
            fromHead = fromHead->next;
        }
        tail = fromHead;
        tail->next = NULL;
        return;
    }
    if(fromK != NULL)
    {
        while(true)
        {
            if(fromHead->next == fromK->next)
            {
                fromK->next = NULL;
                tail = fromK;
                break;
            }
            fromHead = fromHead->next;
            fromK = fromK->next;
        }
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

    tail->next = getNodeAt(head, 0);

    removeCycle(head, tail);
    display(head);
}