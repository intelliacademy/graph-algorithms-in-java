package com.intelliacademy.ga.cp4;

import com.intelliacademy.ga.util.RecVertex;

public class DepthFirstSearch_WIth_Recursion_Overview {
    public static void main(String[] args) {
        RecVertex rootVertex = RecVertex.of("A");
        RecVertex vertexB = RecVertex.of("B");
        RecVertex vertexC = RecVertex.of("C");
        RecVertex vertexD = RecVertex.of("D");
        RecVertex vertexE = RecVertex.of("E");
        RecVertex vertexF = RecVertex.of("F");
        RecVertex vertexG = RecVertex.of("G");
        RecVertex vertexH = RecVertex.of("H");
        RecVertex vertexI = RecVertex.of("I");
        RecVertex vertexJ = RecVertex.of("J");
        RecVertex vertexK = RecVertex.of("K");
        RecVertex vertexL = RecVertex.of("L");

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


        RecDepthFirstSearch depthFirstSearch  = new RecDepthFirstSearch(rootVertex);
        depthFirstSearch.traversal();
    }
}
