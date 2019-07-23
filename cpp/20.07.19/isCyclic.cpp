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

bool forest(int v, vector<bool> &visited)
{
    queue<int> q;
    q.push(v);

    while(q.size() > 0)
    {
        int toRemove = q.front();
        q.pop();
        if(visited[toRemove] == true)   return true;
        visited[toRemove] = true;
        for(int i = 0; i < graph[toRemove].size(); i++)
        {
            edge e = graph[toRemove][i];
            if(visited[e.neighbour] == false)
            {
                q.push(e.neighbour);
            }
        }
    }
    return false;
}

bool allForest()
{
    vector<bool> visited (graph.size(), false);
    for(int i = 0; i < visited.size(); i++)
    {
        if(visited[i] == false)
        {
            if(forest(i, visited))
            {
                return true;
            }
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
    // defineEdge(2, 3, 10);
    defineEdge(0, 3, 40);
    defineEdge(3, 4, 2);
    defineEdge(4, 5, 3);
    defineEdge(5, 6, 3);
    // defineEdge(4, 6, 8);
    cout << allForest();
}