package com.intelliacademy.ga.cp8;

public class Dijkstra {
    private Graph graph;

    private Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public static Dijkstra create(Graph graph) {
        return new Dijkstra(graph);
    }


}
