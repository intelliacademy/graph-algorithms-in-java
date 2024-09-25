package com.intelliacademy.ga.cp6;

public class Topological_Ordering_Overview {
    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = TopologicalOrdering.of(GraphFactory.createGraph());
        topologicalOrdering.printTopologicalOrder();
    }
}
