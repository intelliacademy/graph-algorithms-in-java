package com.intelliacademy.ga.cp6;

public class Topological_Ordering_ShortestPath {
    public static void main(String[] args) {
        var graph = GraphFactory.createGraph2();
        var shortestPath = ShortestPath.of(graph);
        shortestPath.compute();
        shortestPath.printShortestPath();
    }
}
