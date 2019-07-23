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

string getForest(int s, vector<bool>& visited)
{
    queue<int> q;
    q.push(s);
    string forest = "";
    while(q.size() > 0)
    {
        int toRemove = q.front();
        q.pop();
        if(visited[toRemove] == true)
        {
            continue;
        }
        visited[toRemove] = true;
        forest += to_string(toRemove);
        for(int i = 0; i < graph[toRemove].size(); i++)
        {
            edge e = graph[toRemove][i];
            if(visited[e.neighbour] == false)
            {
                q.push(e.neighbour);
            }
        }
    }
    return forest;
}

vector<string> allForest()
{
    vector<bool> visited (graph.size(), false);
    vector<string> allForest;
    for(int i = 0; i < graph.size(); i++)
    {
        if(visited[i] == false)
        {
            allForest.push_back(getForest(i, visited));
        }
    }
    return allForest;
}

int main(int argc, char** argv)
{
    int n = 10;
    vector<int> v1 {9, 5, 2, 3, 6, 1};
    vector<int> v2 {4, 3, 0, 7, 8, 4};

    //adding the vertices
    for(int i = 0; i < n; i++)
    {
        graph.push_back(vector<edge>());
    }

    //adding all the edges
    for(int i = 0; i < v1.size(); i++)
    {
        defineEdge(v1[i], v2[i], 1);
    }

    vector<string> f = allForest();
    int permutations = 0;
    for(int i = 0; i < f.size(); i++)
    {
        for(int j = i + 1; j < f.size(); j++)
        {
            permutations += f[i].size() * f[j].size();
        }
    }
    cout << permutations;
}
