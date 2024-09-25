package com.intelliacademy.ga.cp6;

public record Edge(Vertex target, Integer weight) {
    public Edge {
        if (weight < 1) {
            throw new IllegalArgumentException("Weight must be non-negative or zero");
        }
    }
}
