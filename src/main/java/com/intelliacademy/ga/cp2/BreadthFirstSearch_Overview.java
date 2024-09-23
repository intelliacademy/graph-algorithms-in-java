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
        Vertex vertexF = Vertex.of("F");
        Vertex vertexG = Vertex.of("G");
        Vertex vertexH = Vertex.of("H");
        Vertex vertexI = Vertex.of("I");
        Vertex vertexJ = Vertex.of("J");
        Vertex vertexK = Vertex.of("K");
        Vertex vertexL = Vertex.of("L");

        rootVertex.addAdjacentVertex(vertexB);
        rootVertex.addAdjacentVertex(vertexC);

        vertexB.addAdjacentVertex(vertexD);

        vertexC.addAdjacentVertex(vertexD);

        vertexD.addAdjacentVertex(vertexE);
        vertexD.addAdjacentVertex(vertexF);

        vertexE.addAdjacentVertex(vertexD);

        vertexF.addAdjacentVertex(vertexG);
        vertexF.addAdjacentVertex(vertexH);
        vertexF.addAdjacentVertex(vertexI);

        vertexG.addAdjacentVertex(vertexF);
        vertexG.addAdjacentVertex(vertexJ);
        vertexG.addAdjacentVertex(vertexK);


        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(rootVertex);

        breadthFirstSearch.traverse();

    }
}
