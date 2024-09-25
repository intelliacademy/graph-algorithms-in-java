package com.intelliacademy.ga.cp6;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
    private final Stack<Vertex> stack = new Stack<>();
    private List<Vertex> graph;

    public static TopologicalOrdering of(List<Vertex> graph) {
        var topologicalOrdering =  new TopologicalOrdering();
        topologicalOrdering.graph = graph;
        for (Vertex vertex : graph) {
            if (!vertex.getVisited()) {
                topologicalOrdering.dfs(vertex);
            }
        }
        return topologicalOrdering;
    }

    public List<Vertex> getGraph() {
        return graph;
    }

    private void dfs(Vertex vertex) {
        vertex.visit();
        for (Edge edge : vertex.getEdges()) {
            Vertex neighbour = edge.target();
            if (!neighbour.getVisited()) {
                this.dfs(neighbour);
            }
        }
        stack.push(vertex);
    }

    public void printTopologicalOrder() {
        while (!stack.isEmpty()) {
            System.out.print(" => " + stack.pop().getName());
        }
    }

    public Stack<Vertex> getTopologicalOrder() {
        return stack;
    }
}
