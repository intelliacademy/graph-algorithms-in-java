package com.intelliacademy.ga.cp1;

import com.intelliacademy.ga.util.SimpleVertex;

public class AdjacencyMatrixRepresentation_2 {
    public static void main(String[] args) {
        var vertexA = SimpleVertex.of("A");
        var vertexB = SimpleVertex.of("B");
        var vertexC = SimpleVertex.of("C");
        var vertexD = SimpleVertex.of("D");
        var vertexE = SimpleVertex.of("E");

        vertexA.addAdjacentVertex(vertexB);
        vertexA.addAdjacentVertex(vertexC);

        vertexB.addAdjacentVertex(vertexA);

        vertexC.addAdjacentVertex(vertexA);

        vertexD.addAdjacentVertex(vertexE);

        vertexE.addAdjacentVertex(vertexD);

        vertexA.showAdjacentVertices();
        vertexB.showAdjacentVertices();
        vertexC.showAdjacentVertices();
        vertexD.showAdjacentVertices();
        vertexE.showAdjacentVertices();
    }
}
