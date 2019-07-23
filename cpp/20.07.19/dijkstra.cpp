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

class dPair
{
    public:
        int v;  //vertex
        int c;  //cost
        string p;   //path

    dPair(int v, int c, string p)
    {
        this->v = v;
        this->c = c;
        this->p = p;
    }

    dPair(){}   //this is for the use of the priority queue

    bool operator>(const dPair& other) const
    {
        return this->c > other.c;
    }
};

void dijkstra(int s)
{
    priority_queue <dPair, vector<dPair>, greater<dPair>> q;
    dPair dp(s, 0, to_string(s));
    q.push(dp);

    vector<bool> visited (graph.size(), false);

    while(q.size() > 0)
    {
        dPair toRemove = q.top();
        q.pop();

        if(visited[toRemove.v] == true) continue;

        visited[toRemove.v] = true;

        cout << toRemove.v << "@" << toRemove.c << "via" << toRemove.p << endl;

        for(int i = 0; i < graph[toRemove.v].size(); i++)
        {
            edge e = graph[toRemove.v][i];
            if(visited[e.neighbour] == false)
            {
                dPair dp(e.neighbour, toRemove.c + e.weight, toRemove.p + to_string(e.neighbour));
                q.push(dp);
            }
        }
    }
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
    dijkstra(0);
}