#include <bits/stdc++.h>
#include <climits>
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

void path(int start, int origin, vector<bool> visited, string ans, int count)
{
    if(count == visited.size() - 1)
    {
        cout << ans;
        //to check if its a cycle
        for(int i = 0; i < graph[start].size(); i++)
        {
            edge e = graph[start][i];
            if(e.neighbour == origin)
                cout << "**its a cycle";
        }
        /////////////////////////
        cout << endl;
        return;
    }
    visited[start] = true;
    for(int i = 0; i < graph[start].size(); i++)
    {
        edge e = graph[start][i];
        if(visited[e.neighbour] == false)
        {
            path(e.neighbour, origin, visited, ans + to_string(e.neighbour), count+1);
        }
    }
    visited[start] = false;
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
    defineEdge(2, 5, 5);

    vector<bool> visited (7, false);
    path(0, 0, visited, "0", 0);
}