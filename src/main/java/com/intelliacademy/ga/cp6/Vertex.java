package com.intelliacademy.ga.cp6;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private final String name;
    private final List<Edge> edges;
    private Boolean visited;
    private Vertex predecessor;
    private Integer minDistance;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.predecessor = null;
        this.minDistance = Integer.MAX_VALUE;
    }

    public static Vertex of(String name) {
        return new Vertex(name);
    }

    public void addAdjacentVertex(Vertex vertex, Integer weight) {
        this.edges.add(new Edge(vertex, weight));
    }

    public void addAdjacentVertex(Vertex vertex) {
        this.addAdjacentVertex(vertex,1);
    }

    public void addAdjacentVertex(Vertex ... vertex) {
        Arrays.stream(vertex).forEach(this::addAdjacentVertex);
    }

    public void visit() {
        System.out.println("Visiting vertex: " + this.name);
        this.visited = true;
    }

    public Boolean getVisited() {
        return visited;
    }

    public Integer getMinDistance() {
        return minDistance;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public String getName() {
        return name;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setMinDistance(Integer minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        return "V[" + name + "]";
    }

    public void setPredecessor(Vertex u) {
        this.predecessor = u;
    }
}
