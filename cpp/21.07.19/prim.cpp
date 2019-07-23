#include <bits/stdc++.h>
using namespace std;

class edge{
    public:
        int neighbour;
        int weight;
};

class PrimPair{
    public:
        int v;
        int av;
        int w;
    
    PrimPair(int v, int av, int w)
    {
        this->v = v;
        this->av = av;
        this->w = w;
    }

    bool operator>(const PrimPair& other) const
    {
        return this->w > other.w;
    }
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

void defineEdge(vector<vector<edge>>& mst, int u, int v, int w)
{
    edge e1;
    e1.neighbour = v;
    e1.weight = w;
    mst[u].push_back(e1);

    edge e2;
    e2.neighbour = u;
    e2.weight = w;
    mst[v].push_back(e2);
}

void display(vector<vector<edge>> &mst)
{
    for(int i = 0; i < mst.size(); i++)
    {
        cout << i << "->";
        for(int j = 0; j < mst[i].size(); j++)
        {
            edge e = mst[i][j];
            cout << "["<< e.neighbour << ", " << e.weight << "]";
        }
        cout << endl;
    }
}

void prim()
{
    vector<vector<edge>> mst (graph.size(), vector<edge>());    //minimum spaning tree
    vector<bool> visited (graph.size(), false);
    priority_queue<PrimPair, vector<PrimPair>, greater<PrimPair>> q;
    PrimPair pp = PrimPair(0, -1, 0);
    q.push(pp);

    while(q.size() > 0)
    {
        PrimPair toRemove = q.top();
        q.pop();

        if(visited[toRemove.v] == true) continue;
        visited[toRemove.v] = true;

        if(toRemove.av != -1)
        {
            defineEdge(mst, toRemove.v, toRemove.av, toRemove.w);
        }

        for(int i = 0; i < graph[toRemove.v].size(); i++)
        {
            edge e = graph[toRemove.v][i];
            if(visited[e.neighbour] == false)
            {
                PrimPair pp = PrimPair(e.neighbour, toRemove.v, e.weight);
                q.push(pp);
            }
        }
    }

    display(mst);
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

    prim();
}