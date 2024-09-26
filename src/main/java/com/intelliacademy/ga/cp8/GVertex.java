package com.intelliacademy.ga.cp8;

import java.util.ArrayList;
import java.util.List;

public class GVertex {
    private final String name;
    private boolean visited;
    private Integer distance;
    private GVertex predecessor;
    private final List<GEdge> edges;

    public GVertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
    }

    public void setPredecessor(GVertex predecessor) {
        this.predecessor = predecessor;
    }

    public Integer getDistance() {
        return distance;
    }

    public void zeroDistance() {
        this.distance = 0;
    }

    public void addEdge(GEdge edge) {
        this.edges.add(edge);
    }

    public void addEdge(GVertex target, int weight) {
        this.addEdge(new GEdge(this, target, weight));
    }

    public List<GEdge> getEdges() {
        return edges;
    }

    public Boolean isVisited() {
        return visited;
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public String toString() {
        return " [" + name + "]";
    }
}
