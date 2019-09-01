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

void addAt(Node*& head, Node*& tail, int index, int data)
{
    int s = size(head);
    if(index < 0 && index > s)
    {
        cout << "Really?" << endl;
    }
    else if(index == 0)
    {
        addFirst(head, tail, data);
    }
    else if(index == s)
    {
        addLast(head, tail, data);
    }
    else
    {
        Node* current = head;
        Node* prev = NULL;
        int i = 0;
        while(i != index)
        {
            prev = current;
            current = current->next;
            i++;
        }
        prev->next = new Node(data, current);
    }
    
}

void removeFirst(Node*& head, Node*& tail)
{
    if(head == NULL)
    {
        cout << "Really" << endl;
    }
    else
    {
        Node* temp = head;
        head = head->next;
        delete temp;
        if(head == NULL)
        {
            tail = NULL;
        }
    }
}

void removeLast(Node*& head, Node*& tail)
{
    if(head == NULL)
    {
        cout << "Really" << endl;
    }
    else
    {
        Node* temp = tail;
        int s = size(head)-1;
        Node* node = head;
        int i = 0;
        while(i != s-1)
        {
            node = node->next;
            i++;
        }
        node->next = NULL;
        tail = node;
        if(tail == NULL)
        {
            head = NULL;
        }
        delete temp;
    }
    
}

int main(int argc, char** argv)
{
    Node* head = NULL;
    Node* tail = NULL;

    addAt(head, tail, 0, 100);
    addFirst(head, tail, 10);
    addFirst(head, tail, 20);
    addFirst(head, tail, 30);
    addFirst(head, tail, 40);
    addFirst(head, tail, 50);
    addLast(head, tail, 0);
    addAt(head, tail, 6, 1000);
    addAt(head, tail, 3, 2000);
    removeFirst(head, tail);
    removeLast(head, tail);


    cout << size(head) << endl;
    display(head);
}