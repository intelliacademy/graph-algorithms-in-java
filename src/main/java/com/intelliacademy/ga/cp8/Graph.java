package com.intelliacademy.ga.cp8;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<GVertex> vertices;

    private Graph(List<GVertex> vertices) {
        this.vertices = vertices;
    }

    public static Graph of(List<GVertex> vertices) {
        return new Graph(vertices);
    }

    public List<GVertex> getVertices() {
        return vertices;
    }


    public static class Factory{
        public static Graph random() {
            var vA = new GVertex("A");
            var vB = new GVertex("B");
            var vC = new GVertex("C");
            var vD = new GVertex("D");
            var vE = new GVertex("E");
            var vF = new GVertex("F");
            var vG = new GVertex("G");
            var vH = new GVertex("H");

            vA.addEdge(vB, 5);
            vA.addEdge(vH, 8);
            vA.addEdge(vE, 9);

            vB.addEdge(vH, 4);
            vB.addEdge(vC, 12);
            vB.addEdge(vD, 15);

            vC.addEdge(vD, 3);
            vC.addEdge(vG, 11);

            vD.addEdge(vG, 9);

            vE.addEdge(vH, 5);
            vE.addEdge(vF, 4);
            vE.addEdge(vG, 20);

            vF.addEdge(vG, 13);
            vF.addEdge(vC, 1);

            vH.addEdge(vC, 7);
            vH.addEdge(vF, 6);


            var vertices = List.of(vA, vB, vC, vD, vE, vF, vG, vH);
            return Graph.of(vertices);
        }
    }
}
