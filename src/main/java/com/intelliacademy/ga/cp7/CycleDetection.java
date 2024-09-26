package com.intelliacademy.ga.cp7;

import java.util.List;

public class CycleDetection {

    public void detect(List<CVertex> graph) {
        for (CVertex vertex : graph) {
            if (!vertex.visited()) {
                dfs(vertex);
            }
        }
    }

    private void dfs(CVertex vertex) {
        System.out.println("DFS on vertex: " + vertex);
        vertex.setBeingVisited(true);

        for (CVertex v : vertex.getAdjacentVertices()) {
            System.out.println("Visiting the neighbors of vertex: " + v);
            if (v.isBeingVisited()) {
                System.out.println("Cycle detected");
                return;
            }

            if (!v.visited()) {
                v.visit();
                this.dfs(v);
            }
        }

        vertex.setBeingVisited(false);
        vertex.visit();
    }
}
