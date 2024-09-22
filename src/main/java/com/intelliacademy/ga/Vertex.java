package com.intelliacademy.ga;

public record Vertex(String name) {
    public Vertex {
        if (name == null) {
            throw new IllegalArgumentException("Vertex name cannot be null");
        }
    }

    public static Vertex of(String name) {
        return new Vertex(name);
    }
}
