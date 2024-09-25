package com.intelliacademy.ga.cp2;

import com.intelliacademy.ga.util.SimpleVertex;

public class BreadthFirstSearch_Overview {
    public static void main(String[] args) {
        SimpleVertex rootVertex = SimpleVertex.of("A");
        SimpleVertex vertexB = SimpleVertex.of("B");
        SimpleVertex vertexC = SimpleVertex.of("C");
        SimpleVertex vertexD = SimpleVertex.of("D");
        SimpleVertex vertexE = SimpleVertex.of("E");
        SimpleVertex vertexF = SimpleVertex.of("F");
        SimpleVertex vertexG = SimpleVertex.of("G");
        SimpleVertex vertexH = SimpleVertex.of("H");
        SimpleVertex vertexI = SimpleVertex.of("I");
        SimpleVertex vertexJ = SimpleVertex.of("J");
        SimpleVertex vertexK = SimpleVertex.of("K");
        SimpleVertex vertexL = SimpleVertex.of("L");

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

        vertexH.addAdjacentVertex(vertexL);
        vertexL.addAdjacentVertex(vertexK);


        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(rootVertex);

        breadthFirstSearch.traverse();

    }
}
