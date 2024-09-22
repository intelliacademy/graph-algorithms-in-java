package com.intelliacademy.ga.cp1;

import com.intelliacademy.ga.Vertex;

public class AdjacencyMatrixRepresentation {
    public static void main(String[] args) {
        var vertexes = new Vertex[]{Vertex.of("A"), Vertex.of("B"), Vertex.of("C"), Vertex.of("D"), Vertex.of("E")};

        var adjacencyList = new Integer[][]{
                {0,2,3,0,4},
                {0,1,0,0,0},
                {0,6,0,0,8},
                {0,0,0,5,0},
                {0,7,0,0,1}
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
