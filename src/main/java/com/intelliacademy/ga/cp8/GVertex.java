package com.intelliacademy.ga.cp8;

import java.util.ArrayList;
import java.util.List;

public class GVertex<D> implements Comparable<GVertex<D>> {
    private final D data;
    private boolean visited;
    private Integer distance;
    private GVertex<D> predecessor;
    private final List<GEdge<D>> edges;

    public GVertex(D data) {
        this.data = data;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
    }

    public void setPredecessor(GVertex<D> predecessor) {
        this.predecessor = predecessor;
    }

    public Integer getDistance() {
        return distance;
    }

    public void zeroDistance() {
        this.distance = 0;
    }

    public GVertex<D> maxDistance() {
        this.distance = Integer.MAX_VALUE;
        return this;
    }

    public void addEdge(GEdge<D> edge) {
        this.edges.add(edge);
    }

    public void addEdge(GVertex<D> target, int weight) {
        this.addEdge(new GEdge<D>(this, target, weight));
    }

    public List<GEdge<D>> getEdges() {
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
        return " [" + data + "]";
    }

    @Override
    public int compareTo(GVertex o) {
        return this.distance.compareTo(o.distance);
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public GVertex<D> getPredecessor() {
        return predecessor;
    }
}
