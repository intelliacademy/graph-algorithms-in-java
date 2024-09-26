package com.intelliacademy.ga.cp7;

import com.intelliacademy.ga.cp6.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CVertex {
    private String name;
    private Boolean visited;
    private Boolean beingVisited;
    private List<CVertex> adjacentVertices;


    public CVertex(String name) {
        this.name = name;
        this.visited = false;
        this.beingVisited = false;
        this.adjacentVertices = new ArrayList<>();
    }

    public static CVertex of(String name) {
        return new CVertex(name);
    }

    public Boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(Boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public Boolean visited() {
        return visited;
    }

    public void visit(){
        System.out.println("Visiting vertex: " + this.name);
        this.visited = true;
        this.beingVisited = true;
    }

    public void addAdjacentVertex(CVertex ... vertex) {
        this.adjacentVertices.addAll(Arrays.asList(vertex));
    }


    public List<CVertex> getAdjacentVertices() {
        return adjacentVertices;
    }


    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
