package com.intelliacademy.ga.cp4;

import com.intelliacademy.ga.util.RecVertex;
import com.intelliacademy.ga.util.Vertex;

import java.util.Stack;

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
