#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;

class edge{
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

bool bfs(int start, int destination)
{
    vector<bool> visited (graph.size(), false);
    queue<int> q;
    q.push(start);
    while(q.size() > 0)
    {
        int toRemove = q.front();
        q.pop();
        visited[toRemove] = true;
        if(toRemove == destination)
        {
            return true;
        }
        cout << toRemove << " ";
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

    bfs(0, 6);
}
