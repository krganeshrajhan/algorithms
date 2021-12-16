package algorithms.greedy.minimumspanningtree;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumSpanningTree {

    public static void KruskalMST(Graph g) {
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        for(int i = 0; i < g.edge.length; i++) {
            List<Integer> list = map.getOrDefault(g.edge[i].weight, new ArrayList<>());
            list.add(i);
            map.put(g.edge[i].weight, list);
        }
        HashSet<Integer> connections[] = new HashSet[g.Vertex];
        for(int i = 0; i < g.Vertex; i++) {
            connections[i] = new HashSet<>();
        }
        SortedSet<Integer> removableEdges = new TreeSet<>(Comparator.reverseOrder());
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for(int e : entry.getValue()) {
                int s = g.edge[e].source;
                int d = g.edge[e].destination;
                if(connections[s].contains(d)) {
                    removableEdges.add(e);
                    continue;
                }
                connections[s].addAll(connections[d]);
                connections[s].remove(s);
                connections[d].addAll(connections[s]);
                connections[d].remove(d);
                connections[s].add(d);
                connections[d].add(s);
                for(int v : connections[d]) {
                    if(!connections[v].contains(s) && v != s)
                        connections[v].add(s);
                }
                for(int v : connections[s]) {
                    if(!connections[v].contains(d) && v != d)
                        connections[v].add(d);
                }
            }
        }
        for(int rem : removableEdges) {
            (Arrays.stream(g.edge).skip(rem).collect(Collectors.toList())).toArray(g.edge);
        }
        System.out.println("source" + " , " + "destination");
    }

    public static void main(String[] args) {
        int V = 4, E = 5;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].source = 0;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].source = 2;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 4;

        System.out.println("Minimum Spanning Tree of Graph 1");
        KruskalMST(graph);
        System.out.println();


        V = 6;
        E = 15;
        Graph graph1 = new Graph(V, E);


        graph1.edge[0].source = 0;
        graph1.edge[0].destination = 1;
        graph1.edge[0].weight = 4;

        graph1.edge[1].source = 0;
        graph1.edge[1].destination = 2;
        graph1.edge[1].weight = 3;

        graph1.edge[2].source = 1;
        graph1.edge[2].destination = 2;
        graph1.edge[2].weight = 1;


        graph1.edge[3].source = 1;
        graph1.edge[3].destination = 3;
        graph1.edge[3].weight = 2;

        graph1.edge[4].source = 2;
        graph1.edge[4].destination = 3;
        graph1.edge[4].weight = 4;

        graph1.edge[5].source = 3;
        graph1.edge[5].destination = 4;
        graph1.edge[5].weight = 2;

        graph1.edge[6].source = 4;
        graph1.edge[6].destination = 5;
        graph1.edge[6].weight = 6;

        System.out.println("Minimum Spanning Tree of Graph 2");
        KruskalMST(graph1);
    }
}

