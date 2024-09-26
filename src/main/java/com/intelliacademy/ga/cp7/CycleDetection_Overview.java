package com.intelliacademy.ga.cp7;

import java.util.List;

public class CycleDetection_Overview {
    public static void main(String[] args) {
        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.detect(createGraph());
    }


    public static List<CVertex> createGraph(){
        var vertexA = CVertex.of("A");
        var vertexB = CVertex.of("B");
        var vertexC = CVertex.of("C");
        var vertexD = CVertex.of("D");
        var vertexE = CVertex.of("E");
        var vertexF = CVertex.of("F");

        vertexA.addAdjacentVertex(vertexC,vertexE);
        vertexC.addAdjacentVertex(vertexB,vertexF);
        vertexD.addAdjacentVertex(vertexA);
        vertexE.addAdjacentVertex(vertexD);
        return List.of(vertexA,vertexB,vertexC,vertexD,vertexE,vertexF);
    }
}
