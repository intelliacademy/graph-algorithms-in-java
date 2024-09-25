package com.intelliacademy.ga.cp2;

import com.intelliacademy.ga.util.SimpleVertex;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class BreadthFirstSearch {
    private final SimpleVertex rootVertex;

    private final Queue<SimpleVertex> queue = new LinkedList<>();


    public BreadthFirstSearch(SimpleVertex rootVertex) {
        this.rootVertex = rootVertex;
    }

    public void traverse() {
        addVertex(rootVertex.visit());

        while (!queue.isEmpty()) {
            var currentVertex = removeVertex();

            if (currentVertex.isPresent()) {
                for (SimpleVertex vertex : currentVertex.get().adjacentVertices()) {
                    if (!vertex.visited()) {
                        addVertex(vertex.visit());
                    }
                }
            }
        }
    }

    private void addVertex(SimpleVertex vertex) {
        System.out.println(vertex.name() + " added to the queue");
        queue.add(vertex);
        this.showQueue();
    }

    public void showQueue() {
        System.out.println("Queue: " + queue);
    }


    private Optional<SimpleVertex> removeVertex() {
        if (queue.isEmpty()) {
            return Optional.empty();
        }
        var vertex = queue.poll();
        System.out.println(vertex.name() + " removed from the queue");
        this.showQueue();
        return Optional.of(vertex);
    }

}
