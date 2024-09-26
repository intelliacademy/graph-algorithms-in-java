package com.intelliacademy.ga.cp8;

import java.util.ArrayList;
import java.util.List;

public class GVertex {
    private final String name;
    private boolean visited;
    private boolean beingVisited;
    private Integer minDistance;
    private GVertex processor;
    private final List<GEdge> edges;

    public GVertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.beingVisited = false;
        this.minDistance = Integer.MAX_VALUE;
    }

    public void setProcessor(GVertex processor) {
        this.processor = processor;
    }

    public Integer getMinDistance() {
        return minDistance;
    }

    public void zeroDistance() {
        this.minDistance = 0;
    }

    public void addEdge(GEdge edge) {
        this.edges.add(edge);
    }

    public void addEdge(GVertex target, int weight) {
        this.addEdge(new GEdge(target, weight));
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

    public Boolean isBeingVisited() {
        return beingVisited;
    }

    public void beingVisit() {
        this.beingVisited = true;
    }

    public void beingUnVisit() {
        this.beingVisited = false;
    }

    @Override
    public String toString() {
        return " [" + name + "]";
    }
}
