package com.intelliacademy.ga.cp10;

import com.intelliacademy.ga.cp8.GEdge;
import com.intelliacademy.ga.cp8.GVertex;
import lombok.Data;

import java.util.List;

@Data
public final class BellmanFord <D>{
    private final List<GVertex<D>> vertices;
    private final List<GEdge<D>> edges;

    public BellmanFord(List<GVertex<D>> vertices, List<GEdge<D>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }


    public void run(GVertex<D> startVertex) {
        startVertex.zeroDistance();

        // Relax all edges |V| - 1 times. A simple shortest path from startVertex to any other vertex can have at-most |V| - 1 edges
        for (int i = 0; i < vertices.size() - 1; i++) {
            for (GEdge<D> edge : edges) {
                var source = edge.source();
                var target = edge.target();
                if (source.getDistance() + edge.weight() < target.getDistance()) {
                    target.setDistance(source.getDistance() + edge.weight());
                    target.setPredecessor(source);
                }
            }
        }

        // Check for negative-weight cycles. The above step guarantees the shortest distances if the graph doesn't contain a negative-weight cycle. If we get a shorter path, then there is a cycle.
        for (GEdge<D> edge : edges) {
            var source = edge.source();
            var target = edge.target();
            if (source.getDistance() + edge.weight() < target.getDistance()) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

    }
}

