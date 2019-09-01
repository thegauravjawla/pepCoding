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

void addFirst(Node*& head, int data)
{
    if(head == NULL)
    {
        head = new Node(data, NULL);
        return;
    }
    Node* node = new Node(data, head);
    head = node;
    //or simply
    // head = new Node(data, head); :D
}

void display(Node* head)
{
    for(Node* i = head; i != NULL; i = i->next)
    {
        cout << i->data << " ";
    }
    cout << endl;
}

int main(int argc, char** argv)
{
    Node* head = NULL;
    Node* tail = NULL;

    addFirst(head, 10);
    addFirst(head, 20);
    addFirst(head, 30);
    addFirst(head, 40);
    addFirst(head, 50);

    display(head);
}