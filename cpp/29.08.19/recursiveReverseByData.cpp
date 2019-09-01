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
    if(head == NULL)
    {
        tail = head = new Node(data, NULL);
        return;
    }
    head = new Node(data, head);
}

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
    for(Node* i = head; i != NULL; i = i->next)
    {
        cout << i->data << " ";
    }
    cout << endl;
}

int size(Node* head)
{
    int count = 0;
    Node* i = head;
    while(i != NULL)
    {
        i = i->next;
        count++;
    }
    return count;
}

void reverse(Node*& left, Node* right, int& size, int count)
{
    if(right == NULL)
    {
        return;
    }

    size = size+1;
    reverse(left, right->next, size, count+1);

    if(count < size/2)
    {
        int temp = left->data;
        left->data = right->data;
        right->data = temp;
    }
    left = left->next;
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
    addLast(head, tail, 0);

    display(head);
    Node* left = head;
    Node* right = head;
    int size = 0, count = 0;
    reverse(left, right, size, count);
    display(head);
}