package com.intelliacademy.ga.cp4;

import com.intelliacademy.ga.util.RecVertex;

public class DepthFirstSearch_WIth_Recursion_Overview {
    public static void main(String[] args) {
//        RecVertex rootVertex = RecVertex.of("A");
//        RecVertex vertexB = RecVertex.of("B");
//        RecVertex vertexC = RecVertex.of("C");
//        RecVertex vertexD = RecVertex.of("D");
//        RecVertex vertexE = RecVertex.of("E");
//        RecVertex vertexF = RecVertex.of("F");
//        RecVertex vertexG = RecVertex.of("G");
//        RecVertex vertexH = RecVertex.of("H");
//        RecVertex vertexI = RecVertex.of("I");
//        RecVertex vertexJ = RecVertex.of("J");
//        RecVertex vertexK = RecVertex.of("K");
//        RecVertex vertexL = RecVertex.of("L");
//
//
//        rootVertex.addAdjacentVertex(vertexB);
//
//        vertexB.addAdjacentVertex(vertexC);
//        vertexB.addAdjacentVertex(vertexD);
//
//        vertexD.addAdjacentVertex(vertexF);
//
//        rootVertex.addAdjacentVertex(vertexL);
//
//        rootVertex.addAdjacentVertex(vertexG);
//
//        vertexG.addAdjacentVertex(vertexH);
//
//
//        RecDepthFirstSearch depthFirstSearch  = new RecDepthFirstSearch(rootVertex);
//        depthFirstSearch.traversal();



        RecVertex vertex0 = RecVertex.of("0");
        RecVertex vertex1 = RecVertex.of("1");
        RecVertex vertex2 = RecVertex.of("2");
        RecVertex vertex3 = RecVertex.of("3");
        RecVertex vertex4 = RecVertex.of("4");
        RecVertex vertex5 = RecVertex.of("5");
        RecVertex vertex6 = RecVertex.of("6");
        RecVertex vertex7 = RecVertex.of("7");

        vertex0.addAdjacentVertex(vertex1,vertex4);
        vertex1.addAdjacentVertex(vertex0,vertex3,vertex5);
        vertex2.addAdjacentVertex(vertex4);
        vertex3.addAdjacentVertex(vertex1,vertex5,vertex7);
        vertex4.addAdjacentVertex(vertex0,vertex2,vertex7);
        vertex5.addAdjacentVertex(vertex3,vertex1);
        vertex6.addAdjacentVertex(vertex7);
        vertex7.addAdjacentVertex(vertex3,vertex6,vertex4);

        RecDepthFirstSearch recDepthFirstSearch = new RecDepthFirstSearch(vertex1);
        recDepthFirstSearch.traversal();


    }
}
