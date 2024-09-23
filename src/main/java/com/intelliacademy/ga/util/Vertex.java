package com.intelliacademy.ga.util;

import java.util.ArrayList;
import java.util.List;

public record Vertex(String name, Boolean visited, List<Vertex> adjacentVertices) {
    public Vertex {
        if (name == null) {
            throw new IllegalArgumentException("Vertex name cannot be null");
        }
    }

    public static Vertex of(String name) {
        return new Vertex(name,false, new ArrayList<>());
    }

    public Vertex visit() {
        return new Vertex(name, true, adjacentVertices);
    }

    public Boolean hasUnvisitedAdjacentVertex() {
        return adjacentVertices.stream().anyMatch(vertex -> !vertex.visited());
    }

    public Boolean hasNeighbour() {
        return !adjacentVertices.isEmpty();
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
            System.out.print(vertex.name() + " " + vertex.visited() + ", ");
        }
        System.out.println();
    }
}
