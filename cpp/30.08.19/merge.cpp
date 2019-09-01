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

void addLast(Node*& head, Node*& tail, int data)
{
    if(tail==NULL)
    {
        Node* node = new Node(data, NULL);
        head = node;
        tail = node;
        return;
    }
    tail->next = new Node(data, NULL);
    tail = tail->next;
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

void merge(Node* head1, Node* head2, Node*& newHead, Node*& newTail)
{
    while(head1 != NULL && head2 != NULL)
    {
        if(head1->data < head2->data)
        {
            addLast(newHead, newTail, head1->data);
            head1 = head1->next;
        }
        else
        {
            addLast(newHead, newTail, head2->data);
            head2 = head2->next;
        }
    }
    if(head1 == NULL)
    {
        Node* temp = head2;
        head2 = head1;
        head1 = temp;
    }
    while(head1 != NULL)
    {
        addLast(newHead, newTail, head1->data);
        head1 = head1->next;
    }
}

int main(int argc, char** argv)
{
    Node* head = NULL;
    Node* tail = NULL;
    Node* head2 = NULL;
    Node* tail2 = NULL;

    addFirst(head, tail, 70);
    addFirst(head, tail, 60);
    addFirst(head, tail, 50);
    addFirst(head, tail, 40);
    addFirst(head, tail, 30);
    addFirst(head, tail, 20);
    addFirst(head, tail, 10);
    addLast(head, tail, 80);
    addLast(head, tail, 90);
    addFirst(head2, tail2, 51);
    addFirst(head2, tail2, 42);
    addFirst(head2, tail2, 30);
    addFirst(head2, tail2, 22);
    addFirst(head2, tail2, 10);

    display(head);
    display(head2);
    //here we need head and head2 lists for future, hence we have written the code of merge such that the origional
    //lists are preserved. But if you dont need them, either delete them through a loop, or don't make the new list at all.
    Node* newHead = NULL;
    Node* newTail = NULL;
    merge(head, head2, newHead, newTail);
    display(newHead);
}