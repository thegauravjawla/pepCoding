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

Node* mid(Node* head, Node* tail)
{
    Node* fast = head;
    Node* slow = head;
    while(fast!=tail && fast->next!=tail)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
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

void mergeSort(Node*& head, Node*& tail)
{
    if(head == tail)
    {
        Node* n = new Node(head->data, NULL);
        head = tail = n;
        return;
    }

    Node* m = mid(head, tail);

    Node* leftHead = head;
    Node* leftTail = m;
    Node* rightHead = m->next;
    Node* rightTail = tail;

    mergeSort(leftHead, leftTail);
    mergeSort(rightHead, rightTail);

    Node* newHead = NULL;
    Node* newTail = NULL;
    merge(leftHead, rightHead, newHead, newTail);
    
    head = newHead;
    tail = newTail;
    //handling memory leak
    while(leftHead != NULL)
    {
        Node* temp = leftHead;
        leftHead = leftHead->next;
        delete temp;
    }
    while(rightHead != NULL)
    {
        Node* temp = rightHead;
        rightHead = rightHead->next;
        delete temp;
    }
}

int main(int argc, char** argv)
{
    Node* head = NULL;
    Node* tail = NULL;
    Node* head2 = NULL;
    Node* tail2 = NULL;

    addFirst(head, tail, 40);
    addFirst(head, tail, 20);
    addFirst(head, tail, 60);
    addFirst(head, tail, 20);
    addFirst(head, tail, 37);
    addFirst(head, tail, 33);
    addFirst(head, tail, 864);
    addLast(head, tail, 801);
    addLast(head, tail, 0);
    addFirst(head, tail, 452);
    addFirst(head, tail, 11);
    addFirst(head, tail, 303);
    addFirst(head, tail, 22);
    addFirst(head, tail, 103);
    display(head);
    Node* nh = head;
    Node* nt = tail;
    mergeSort(nh, nt);
    display(nh);
}