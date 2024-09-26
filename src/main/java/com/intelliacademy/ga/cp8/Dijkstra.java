package com.intelliacademy.ga.cp8;

import java.util.*;

public class Dijkstra<D> {
    private final Queue<GVertex<D>> queue;
    private final Graph<D> graph;

    private Dijkstra(Graph<D> graph) {
        this.graph = graph;
        this.queue = new PriorityQueue<>();
        this.queue.add(this.graph.getStartVertex());
    }

    public static <D> Dijkstra<D> create(Graph<D> graph) {
        return new Dijkstra<>(graph);
    }

    public void compute(){
        while (!this.queue.isEmpty()){
            GVertex<D> vertex = this.queue.poll();
            for (GEdge<D> edge : vertex.getEdges()){
                GVertex<D> target = edge.target();
                var distance = vertex.getDistance() + edge.weight();
                if (distance < target.getDistance()){
                    this.queue.remove(target);
                    target.setPredecessor(vertex);
                    target.setDistance(distance);
                    this.queue.add(target);
                }
            }
        }
    }

    public List<GVertex<D>> getShortestPath(GVertex<D> target){
        var path = new ArrayList<GVertex<D>>();
        for (GVertex<D> vertex = target; vertex != null; vertex = vertex.getPredecessor()){
            System.out.println(vertex + " " + vertex.getDistance());
            path.add(vertex);
        }
        return path;
    }


}
