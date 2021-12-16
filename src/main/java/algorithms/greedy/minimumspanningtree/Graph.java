package algorithms.greedy.minimumspanningtree;

public class Graph {
    //class to represent an edge
    public static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public int compareTo(Edge var) {
            return this.weight - var.weight;
        }
    }


    //class to represent disjoint sets
    public static class DisjointSets {
        int p, r;
    }

    int Vertex, Edges;
    Edge edge[];


    @SuppressWarnings("unchecked")

    public Graph(int v, int e) {
        Vertex = v;
        Edges = e;
        edge = new Edge[Edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    //fund function
    int find(DisjointSets mySet[], int v) {
        // find root and make root as parent of i (path compression)
        if (mySet[v].p != v)
            mySet[v].p = find(mySet, mySet[v].p);

        return mySet[v].p;
    }

    //merge function
    void merge(DisjointSets mySet[], int i, int j) {
        int set_i = find(mySet, i);
        int set_j = find(mySet, j);

        if (mySet[set_i].r < mySet[set_j].r)
            mySet[set_i].p = set_j;
        else if (mySet[set_i].r > mySet[set_j].r)
            mySet[set_j].p = set_i;

        else {
            mySet[set_j].p = set_i;
            mySet[set_i].r++;
        }
    }
}
