package com.intelliacademy.ga.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class RecVertex {
    private final String name;
    private Boolean visited;
    private final List<RecVertex> adjacentVertices;

    public RecVertex(String name, Boolean visited, List<RecVertex> adjacentVertices) {
        if (name == null) {
            throw new IllegalArgumentException("Vertex name cannot be null");
        }
        this.name = name;
        this.visited = visited;
        this.adjacentVertices = adjacentVertices;
    }

    public static RecVertex of(String name) {
        return new RecVertex(name, false, new ArrayList<>());
    }

    public RecVertex visit() {
        visited = true;
        return this;
    }

    public void visitNext(){
        while (this.hasUnvisitedAdjacentVertex()){
            for (RecVertex vertex : this.unvisitedAdjacent()){
                if (!vertex.visited()){
                    vertex.visit();
                    System.out.println("Visited [" + vertex.name + "]");
                    vertex.visitNext();
                }
            }
        }
    }



    public List<RecVertex> unvisitedAdjacent(){
        return this.adjacentVertices.stream().filter(vertex->!vertex.visited).toList();
    }

    public Boolean hasUnvisitedAdjacentVertex() {
        return adjacentVertices.stream().anyMatch(vertex -> !vertex.visited());
    }

    public Boolean hasNeighbour() {
        return !adjacentVertices.isEmpty();
    }

    public void addAdjacentVertex(RecVertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex cannot be null");
        }
        adjacentVertices.add(vertex);
    }

    public void showAdjacentVertices() {
        System.out.print(name + " -> ");
        for (RecVertex vertex : adjacentVertices) {
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

    public List<RecVertex> adjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RecVertex) obj;
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
