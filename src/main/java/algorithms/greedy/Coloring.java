package algorithms.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Coloring {

    public static void greedyColoring(Graph g) {
        int numofVertices = g.getVertices();
        int[] result = new int[numofVertices];

        Arrays.fill(result, -1);

        for(int i = 0; i < result.length ; i++) {
            if(i == 0) {
                result[i] = 0;
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for(int vertex : g.getAdj()[i]) {
                if(result[vertex] != -1) {
                    set.add(result[vertex]);
                }
            }
            int col = 0;
            while(true) {
                if(!set.contains(col)) {
                    result[i] = col;
                    break;
                }
                col++;
            }
        }

        for (int i = 0; i < numofVertices; i++) {
            System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);

        Coloring.greedyColoring(g1);
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        Coloring.greedyColoring(g2);
    }

}

class Graph {
    private int vertices; //number of vertices
    private LinkedList< Integer > adjacencyList[]; //Adjacency Lists
    @SuppressWarnings("unchecked")
        // Constructor
    Graph(int vert) {
        this.vertices = vert;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < this.vertices; ++i)
            this.adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
        this.adjacencyList[destination].add(source);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }
};
