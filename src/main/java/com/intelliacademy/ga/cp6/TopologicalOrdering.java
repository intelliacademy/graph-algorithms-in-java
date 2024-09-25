package com.intelliacademy.ga.cp6;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
    private final Stack<Vertex> stack = new Stack<>();

    public TopologicalOrdering(List<Vertex> graph) {
        for (Vertex vertex : graph) {
            if (!vertex.getVisited()) {
                dfs(vertex);
            }
        }
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
}
