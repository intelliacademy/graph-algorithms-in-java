package com.intelliacademy.ga.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SimpleVertex {
    private final String name;
    private Boolean visited;
    private final List<SimpleVertex> adjacentVertices;

    public SimpleVertex(String name, Boolean visited, List<SimpleVertex> adjacentVertices) {
        if (name == null) {
            throw new IllegalArgumentException("Vertex name cannot be null");
        }
        this.name = name;
        this.visited = visited;
        this.adjacentVertices = adjacentVertices;
    }

    public static SimpleVertex of(String name) {
        return new SimpleVertex(name, false, new ArrayList<>());
    }

    public SimpleVertex visit() {
        visited = true;
        return this;
    }

    public List<SimpleVertex> unvisitedAdjacent(){
        return this.adjacentVertices.stream().filter(vertex->!vertex.visited).toList();
    }

    public Boolean hasUnvisitedAdjacentVertex() {
        return adjacentVertices.stream().anyMatch(vertex -> !vertex.visited());
    }

    public Boolean hasNeighbour() {
        return !adjacentVertices.isEmpty();
    }

    public void addAdjacentVertex(SimpleVertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex cannot be null");
        }
        adjacentVertices.add(vertex);
    }

    public void showAdjacentVertices() {
        System.out.print(name + " -> ");
        for (SimpleVertex vertex : adjacentVertices) {
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

    public List<SimpleVertex> adjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SimpleVertex) obj;
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
