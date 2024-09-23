package com.intelliacademy.ga.cp2;

import com.intelliacademy.ga.util.Tree;
import com.intelliacademy.ga.util.TreeUtil;
import com.intelliacademy.ga.util.Vertex;

public class BreadthFirstSearch_Overview {
    public static void main(String[] args) {
        Vertex rootVertex = Vertex.of("A");
        Vertex vertexB = Vertex.of("B");
        Vertex vertexC = Vertex.of("C");
        Vertex vertexD = Vertex.of("D");
        Vertex vertexE = Vertex.of("E");

        rootVertex.addAdjacentVertex(vertexB);
        rootVertex.addAdjacentVertex(vertexC);

        vertexB.addAdjacentVertex(rootVertex);

        vertexC.addAdjacentVertex(rootVertex);

        vertexD.addAdjacentVertex(vertexE);

        vertexE.addAdjacentVertex(vertexD);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(rootVertex);

        breadthFirstSearch.traverse();

    }
}
