package com.intelliacademy.ga.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Vertex {
    private final String name;
    private Boolean visited;
    private final List<Vertex> adjacentVertices;

    public Vertex(String name, Boolean visited, List<Vertex> adjacentVertices) {
        if (name == null) {
            throw new IllegalArgumentException("Vertex name cannot be null");
        }
        this.name = name;
        this.visited = visited;
        this.adjacentVertices = adjacentVertices;
    }

    public static Vertex of(String name) {
        return new Vertex(name, false, new ArrayList<>());
    }

    public Vertex visit() {
        visited = true;
        return this;
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

    public String name() {
        return name;
    }

    public Boolean visited() {
        return visited;
    }

    public List<Vertex> adjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Vertex) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.visited, that.visited) &&
                Objects.equals(this.adjacentVertices, that.adjacentVertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, visited, adjacentVertices);
    }

    @Override
    public String toString() {
        return "Vertex[" + "name=" + name + "]";
    }

}
