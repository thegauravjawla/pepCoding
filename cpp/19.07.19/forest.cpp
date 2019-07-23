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

//function to return all the strings of forest in 1 place
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

    vector<string> ans = allForest();
    for(int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << endl;
    }
}
