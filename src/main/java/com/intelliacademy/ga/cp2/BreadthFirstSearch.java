package com.intelliacademy.ga.cp2;

import com.intelliacademy.ga.util.Vertex;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class BreadthFirstSearch {
    private final Vertex rootVertex;

    private final Queue<Vertex> queue = new LinkedList<>();


    public BreadthFirstSearch(Vertex rootVertex) {
        this.rootVertex = rootVertex;
    }

    public void traverse() {
        addVertex(rootVertex.visit());

        while (!queue.isEmpty()) {
            var currentVertex = removeVertex();

            if (currentVertex.isPresent()) {
                for (Vertex vertex : currentVertex.get().adjacentVertices()) {
                    if (!vertex.visited()) {
                        addVertex(vertex.visit());
                    }
                }
            }
        }
    }

    private void addVertex(Vertex vertex) {
        System.out.println(vertex.name() + " added to the queue");
        queue.add(vertex);
    }


    private Optional<Vertex> removeVertex() {
        if (queue.isEmpty()) {
            return Optional.empty();
        }
        var vertex = queue.poll();
        System.out.println(vertex.name() + " removed from the queue");
        return Optional.of(vertex);
    }

}
