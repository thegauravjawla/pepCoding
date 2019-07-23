import java.util.*;
public class kruskal
{
    //it is not required here at all
    public static class Edge
    {
        int v;
        int w;

        Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
    }

    //the main class that we need
    public static class KEdge implements Comparable<KEdge>
    {
        int u;
        int v;
        int w;

        KEdge(int u, int v, int w)
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(KEdge other)
        {
            return this.w - other.w;
        }
    }

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

    public static void addEdge(ArrayList<ArrayList<Edge>> graph, int u, int v, int w)
    {
        Edge e = new Edge(v, w);
        graph.get(u).add(e);

        Edge e2 = new Edge(u, w);
        graph.get(v).add(e2);
    }

    static void display(ArrayList<ArrayList<Edge>> graph)
    {
        for(int i = 0; i < graph.size(); i++)
        {
            System.out.print(i + " -> ");
            for(int j = 0; j < graph.get(i).size(); j++)
            {
                System.out.print("[" + graph.get(i).get(j).v + ", " + graph.get(i).get(j).w + "]");
            }
            System.out.println();
        }
    }

    public static void mergeCloud(int[] rank, int[] cloud, int u, int v)
    {
        if(rank[u] > rank[v])
            cloud[v] = u;
        else if(rank[v] > rank[u])
            cloud[u] = v;
        else
        {
            cloud[u] = v;
            rank[v]++;
        }
    }

    public static int cloudOf(int[] cloud, int u)
    {
        if(cloud[u] == u)
            return u;
        else
            return cloudOf(cloud, cloud[u]);
    }

    static void kruskal()
    {
        //declaring and filling the things
        ArrayList<ArrayList<Edge>> mst = new ArrayList<ArrayList<Edge>>();
        int[] rank = new int[graph.size()];
        int[] cloud = new int[graph.size()];
        for(int i = 0; i < graph.size(); i++)
        {
            rank[i] = 1;
            cloud[i] = i;
            mst.add(new ArrayList<Edge>());
        }
        ///////////////////////////////////

        PriorityQueue<KEdge> q = new PriorityQueue<KEdge>();
        //converting the edges into kruskal edges
        for(int i = 0; i < graph.size(); i++) //it is u here
        {
            for(int j= 0; j < graph.get(i).size(); j++)
            {
                Edge e = graph.get(i).get(j);
                if(i < e.v)
                {
                    KEdge ke = new KEdge(i, e.v, e.w);
                    q.add(ke);
                }
            }
        }
        ////////////////////////////////////////////

        while(q.size() > 0)
        {
            KEdge ke = q.remove();
            int u = ke.u;
            int v = ke.v;
            int uCloud = cloudOf(cloud, u);    //cloud of v means leader of cloud of
            int vCloud = cloudOf(cloud, v);

            if(uCloud != vCloud)
            {
                addEdge(mst, u, v, ke.w);
                mergeCloud(rank, cloud, uCloud, vCloud);
            }
        }
        display(mst);
    }
    public static void main(String[] args) 
    {
        for(int i = 0; i < 7; i++)    graph.add(new ArrayList<Edge>());
        
        addEdge(graph, 0, 1, 20);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 3, 2, 20);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 2, 5, 5);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        // display(graph);
        kruskal();
    }
}