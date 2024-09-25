package com.intelliacademy.ga.cp6;

import java.util.List;

public class ShortestPath {
    private TopologicalOrdering topologicalOrdering;

    public ShortestPath(TopologicalOrdering topologicalOrdering) {
        this.topologicalOrdering = topologicalOrdering;
    }

    public static ShortestPath of(List<Vertex> graph) {
        graph.get(0).setMinDistance(0);
        return new ShortestPath(TopologicalOrdering.of(graph));
    }


    public void compute() {
        var ordering = topologicalOrdering.getTopologicalOrder();
        while (!ordering.isEmpty()) {
            Vertex u = ordering.pop();
            for (Edge edge : u.getEdges()) {
                Vertex v = edge.target();
                if (v.getMinDistance() > u.getMinDistance() + edge.weight()) {
                    v.setMinDistance(u.getMinDistance() + edge.weight());
                    v.setPredecessor(u);
                }
            }
        }
    }


    public void printShortestPath() {
        for (Vertex vertex : topologicalOrdering.getGraph()) {
            System.out.println("Vertex: " + vertex.getName() + " Min distance: " + vertex.getMinDistance() + " Predecessor: " + vertex.getPredecessor());
        }
    }
}
