package com.intelliacademy.ga.cp4;

import com.intelliacademy.ga.util.Vertex;

import java.util.Stack;

public class DepthFirstSearch {
    //We add only visited vertex to stack
    private final Stack<Vertex> stack;

    public DepthFirstSearch(Vertex root) {
        this.stack = new Stack<>();
        this.stack.push(root.visit());
    }

    public void traversal(){
        while (!stack.isEmpty()){
            Vertex actual = this.stack.pop();
            for (Vertex ver: actual.adjacentVertices()){
                if (!ver.visited()){
                    ver.visit();
                    this.stack.push(ver);
                    System.out.println("Visited [" + ver.name() + "]");
                }
            }
        }
    }
}
