#include <bits/stdc++.h>
using namespace std;

class edge
{
    public:
        int neighbour;
        int weight;
};

vector<vector<edge>> graph;

void defineEdge(int u, int v, int w)
{
    edge e1;
    e1.neighbour = v;
    e1.weight = w;
    graph[u].push_back(e1);

    edge e2;
    e2.neighbour = u;
    e2.weight = w;
    graph[v].push_back(e2);
}

bool havePath(int v1, int v2, vector<bool>& visited)
{
    if(v1 == v2)
        return true;

    visited[v1] = true;     //marking visited
    for(int i = 0; i < graph[v1].size(); i++)
    {
        edge e = graph[v1][i];
        if(visited[e.neighbour] == false)   //if the neighbour is unvisited, then:
        {
            bool verdict = havePath(e.neighbour, v2, visited);  // -->  go to that neighbour
            if(verdict == true)
                return true;
        }
    }
    return false;
}

int main(int argc, char** argv)
{
    graph.push_back(vector<edge>());
    graph.push_back(vector<edge>());
    graph.push_back(vector<edge>());
    graph.push_back(vector<edge>());
    graph.push_back(vector<edge>());
    graph.push_back(vector<edge>());
    graph.push_back(vector<edge>());

    defineEdge(0, 1, 10);
    defineEdge(1, 2, 10);
    defineEdge(2, 3, 10);
    defineEdge(0, 3, 40);
    // defineEdge(3, 4, 2);
    defineEdge(4, 5, 3);
    defineEdge(5, 6, 3);
    defineEdge(4, 6, 8);

    vector<bool> visited (7, false);
    bool verdict = havePath(0, 6, visited);
    cout << verdict;
}