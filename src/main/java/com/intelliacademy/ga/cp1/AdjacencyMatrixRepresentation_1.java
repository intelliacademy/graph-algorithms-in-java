package com.intelliacademy.ga.cp1;

import com.intelliacademy.ga.util.SimpleVertex;

public class AdjacencyMatrixRepresentation_1 {
    public static void main(String[] args) {
        var vertexes = new SimpleVertex[]{SimpleVertex.of("A"), SimpleVertex.of("B"), SimpleVertex.of("C"), SimpleVertex.of("D"), SimpleVertex.of("E")};

        var adjacencyList = new Integer[][]{
                {0,2,3,0,4},// A
                {0,1,0,0,0},// B
                {0,6,0,0,8},// C
                {0,0,0,5,0},// D
                {0,7,0,0,1} // E
        };

        for (int i = 0; i < vertexes.length; i++) {
            System.out.print(vertexes[i].name() + " -> ");
            for (int j = 0; j < vertexes.length; j++) {
                if (adjacencyList[i][j] != 0) {
                    System.out.print(vertexes[j].name() + "(" + adjacencyList[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }




}
