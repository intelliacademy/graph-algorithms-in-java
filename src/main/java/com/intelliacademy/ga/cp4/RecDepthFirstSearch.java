package com.intelliacademy.ga.cp4;

import com.intelliacademy.ga.util.RecVertex;

public class RecDepthFirstSearch {
    private final RecVertex vertex;

    public RecDepthFirstSearch(RecVertex root) {
        this.vertex = root;
    }

    public void traversal(){
        vertex.visit();
        System.out.println("Visited [" + vertex.name() + "]");
        vertex.visitNext();
    }
}
