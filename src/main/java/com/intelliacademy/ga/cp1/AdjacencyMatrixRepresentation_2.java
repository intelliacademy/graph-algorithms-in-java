package com.intelliacademy.ga.cp1;

import com.intelliacademy.ga.Vertex;

public class AdjacencyMatrixRepresentation_2 {
    public static void main(String[] args) {
        var vertexA = Vertex.of("A");
        var vertexB = Vertex.of("B");
        var vertexC = Vertex.of("C");
        var vertexD = Vertex.of("D");
        var vertexE = Vertex.of("E");

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
