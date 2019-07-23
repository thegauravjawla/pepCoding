#include <bits/stdc++.h>
using namespace std;

class Edge{
    public:
        int v;
        int w;
    Edge(int v, int w)
    {
        this->v = v;
        this->w = w;
    }
};

vector<vector<Edge>> graph;

void addEdge(int u, int v, int w)
{
    Edge e = Edge(v, w);
    graph[u].push_back(e);
}

void topoRecursion(stack<int>& s, vector<bool>& visited, int u)
{
    visited[u] = true;
    for(int i = 0; i < graph[u].size(); i++)
    {
        Edge e = graph[u][i];
        if(visited[e.v] == false)
        {
            topoRecursion(s, visited, e.v);
        }
    }
    s.push(u);
}

void topo()
{
    stack<int> s;
    vector<bool> visited (graph.size(), false);

    for(int i = 0; i < graph.size(); i++)
    {
        if(visited[i] == false)
        {
            topoRecursion(s, visited, i);
        }
    }
    while(s.size() > 0)
    {
        int temp = s.top();
        s.pop();
        cout << temp << " ";
    }
}

int main(int argc, char** argv)
{
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());

    addEdge(0, 1, 1);
    addEdge(1, 2, 1);
    addEdge(2, 3, 1);
    addEdge(0, 4, 1);
    addEdge(4, 3, 1);
    addEdge(5, 4, 1);
    addEdge(6, 3, 1);
    addEdge(5, 6, 1);

    topo();
}