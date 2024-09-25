package com.intelliacademy.ga.cp6;

import java.util.List;

public class GraphFactory {
    public static List<Vertex> createGraph() {
        var vertexA = Vertex.of("A");
        var vertexB = Vertex.of("B");
        var vertexC = Vertex.of("C");
        var vertexD = Vertex.of("D");
        var vertexE = Vertex.of("E");
        var vertexS = Vertex.of("S");
        var vertexT = Vertex.of("T");

        vertexA.addAdjacentVertex(vertexB,6);

        vertexB.addAdjacentVertex(vertexE,1);
        vertexB.addAdjacentVertex(vertexD,2);

        vertexC.addAdjacentVertex(vertexA,4);
        vertexC.addAdjacentVertex(vertexD,3);

        vertexD.addAdjacentVertex(vertexT,1);

        vertexE.addAdjacentVertex(vertexT,7);

        vertexS.addAdjacentVertex(vertexA,1);
        vertexS.addAdjacentVertex(vertexC,2);

        return List.of(vertexA, vertexB, vertexC, vertexD, vertexE, vertexS, vertexT);
    }
}
