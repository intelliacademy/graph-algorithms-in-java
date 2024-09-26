package com.intelliacademy.ga.cp8;

public record GEdge<D>(GVertex<D> source,GVertex<D> target, int weight) {
    public GEdge{
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        if (target == null) {
            throw new IllegalArgumentException("Target vertex cannot be null");
        }
    }
}
