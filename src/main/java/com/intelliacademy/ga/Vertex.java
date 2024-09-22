package com.intelliacademy.ga;

import java.util.ArrayList;
import java.util.List;

public record Vertex(String name, List<Vertex> adjacentVertices) {
    public Vertex {
        if (name == null) {
            throw new IllegalArgumentException("Vertex name cannot be null");
        }
    }

    public static Vertex of(String name) {
        return new Vertex(name, new ArrayList<>());
    }


    public void addAdjacentVertex(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex cannot be null");
        }
        adjacentVertices.add(vertex);
    }

    public void showAdjacentVertices() {
        System.out.print(name + " -> ");
        for (Vertex vertex : adjacentVertices) {
            System.out.print(vertex.name() + " ");
        }
        System.out.println();
    }
}
