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
        vertex.setBeingVisited(true);

        for (CVertex v : vertex.getAdjacentVertices()) {
            if (v.isBeingVisited()) {
                System.out.println("Cycle detected" + v);
                return;
            }
            if (!v.visited()) {
                v.visit();
                this.dfs(v);
            }
        }
        vertex.setBeingVisited(false);
    }
}
