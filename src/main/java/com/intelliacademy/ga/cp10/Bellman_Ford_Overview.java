package com.intelliacademy.ga.cp10;

import com.intelliacademy.ga.cp8.Graph;

public class Bellman_Ford_Overview {
    public static void main(String[] args) {
        var graph = Graph.Factory.<String>randomNegative();

        var bellmanFord = new BellmanFord<>(graph.getVertices(), graph.getEdges());
        bellmanFord.run(graph.getStartVertex());
    }
}
