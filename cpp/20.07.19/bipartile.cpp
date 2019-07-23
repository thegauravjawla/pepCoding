#include<bits/stdc++.h>
using namespace std;

class edge
{
    public:
        int neighbour;
        int weight;
};

class biPair
{
    public:
        int v;  //vertex
        int l;  //level
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

bool bipartiteForest(int s, vector<int>& visited)
{
    queue <biPair> q;
    biPair bp;
    bp.v = s;
    bp.l = 1;
    q.push(bp);

    while(q.size() > 0)
    {
        biPair toRemove = q.front();
        q.pop();
        if(visited[toRemove.v] != 0)
        {
            int oldLevel = visited[toRemove.v];
            int newLevel = toRemove.l;
            if(oldLevel%2 != newLevel%2)
            {
                return false;
            }
        }
        visited[toRemove.v] = toRemove.l;
        for(int i = 0; i < graph[toRemove.v].size(); i++)
        {
            edge e = graph[toRemove.v][i];
            if(visited[e.neighbour] == 0)
            {
                biPair bp;
                bp.v = e.neighbour;
                bp.l = toRemove.l + 1;
                q.push(bp);
            }
        }
    }
    return true;
}

bool allForest()
{
    vector<int> visited (graph.size(), 0);
    for(int i = 0; i < graph.size(); i++)
    {
        if(visited[i] == 0)
        {
            if(bipartiteForest(i, visited) == false)
            {
                return false;
            }
        }
    }
    return true;
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
    defineEdge(3, 4, 2);
    defineEdge(4, 5, 3);
    defineEdge(5, 6, 3);
    defineEdge(4, 6, 8);
    cout << allForest();
}