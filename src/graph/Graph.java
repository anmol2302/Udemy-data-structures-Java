package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {
    public Map<String, ArrayList<String>> graph;

    public Graph() {

        graph = new HashMap<>();
    }


    public boolean addVertex(String vertex) {

        if (graph.get(vertex) == null) {
            graph.put(vertex, new ArrayList<>());
            return true;
        }
        return false;

    }

    public boolean addEdge(String vertext1, String vertext2) {

        if (graph.containsKey(vertext1) && graph.containsKey(vertext2)) {
            graph.get(vertext1).add(vertext2);
            graph.get(vertext2).add(vertext1);
            return true;

        }

        return false;

    }

    public boolean removeEdge(String vertex1, String vertex2) {

        if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
            graph.get(vertex1).remove(vertex2);
            graph.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (!graph.containsKey(vertex)) return false;
        graph.remove(vertex);
        graph = graph.entrySet().stream().map(e -> {
            e.getValue().remove(vertex);
            return e;
        }).collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue(),(e1, e2)->e1, HashMap::new));
        return true;
    }


    public void printGraph() {
        System.out.println(graph);
    }

    public static void main(String[] args) {

        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "C");
        g.addVertex("D");
        g.addEdge("D", "B");
        g.addVertex("F");
        g.addEdge("B", "F");
        g.printGraph();
        System.out.println("Removing vertex B");
        g.removeVertex("B");
        g.printGraph();
        System.out.println("Removing edge between A and D");
        g.removeEdge("A", "D");
        g.printGraph();
    }


}
