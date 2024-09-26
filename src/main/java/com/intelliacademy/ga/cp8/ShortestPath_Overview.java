package com.intelliacademy.ga.cp8;

public class ShortestPath_Overview {
    public static void main(String[] args) {
        var graph = Graph.Factory.<String>random();
        Dijkstra<String> dijkstra = Dijkstra.create(graph);
        dijkstra.compute();
        dijkstra.getShortestPath(graph.getVertices().get(6));
    }
}
