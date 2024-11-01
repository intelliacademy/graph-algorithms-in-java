package com.intelliacademy.ga.cp10;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Vertex {
    public String name;
    public BigDecimal distance;
    public Vertex predecessor;
    private List<Edge> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.distance = BigDecimal.valueOf(Integer.MAX_VALUE);
        this.predecessor = null;
        this.adjacencyList = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        adjacencyList.add(edge);
    }

    public String toString() {
        return name + " (" + distance + ")";
    }
}

class Edge {
    public Vertex source;
    public Vertex destination;
    public BigDecimal weight;

    public Edge(Vertex source, Vertex destination, BigDecimal weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public void relax() {
        if (destination.distance.compareTo(source.distance.add(weight)) > 0) {
            destination.distance = source.distance.add(weight);
            destination.predecessor = source;
        }
    }

    public String toString() {
        return source.name + " -> " + destination.name + " (" + weight + ")";
    }
}


public class BellmanFord {
}
