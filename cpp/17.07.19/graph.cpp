#include <bits/stdc++.h>
using namespace std;

//defining the edge 

//Given vertex u, it has an edge e, i.e. it has a neighbour v and edge weight w;
class edge
{
    public:
        int neighbour;
        int weight;
};

//array of edges is called is the graph where each edge contains its values as (u, v, w);
vector<vector<edge>> graph;


//defining the edges of the graph
//i.e. adding edges
//aka representing the edges
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

//print the graph
void display()
{
    for(int i = 0; i < graph.size(); i++)
    {
        cout << i << " -> ";
        for(int j = 0; j < graph[i].size(); j++)
        {
            edge e = graph[i][j];
            cout << "[" << e.neighbour << "-" << e.weight << "], ";
        }
        cout << endl;
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

    display();
}
//OUTPUT

// 0 -> [1-10], [3-40], 

//this represents that 0 is connected to 1 with weight 10 and 3 with weight 40


// 1 -> [0-10], [2-10], 
// 2 -> [1-10], [3-10],
// 3 -> [2-10], [0-40], [4-2],
// 4 -> [3-2], [5-3], [6-8], 
// 5 -> [4-3], [6-3],
// 6 -> [5-3], [4-8], 