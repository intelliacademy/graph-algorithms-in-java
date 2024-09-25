package com.intelliacademy.ga.cp4;

import com.intelliacademy.ga.util.SimpleVertex;

import java.util.Stack;

public class DepthFirstSearch {
    //We add only visited vertex to stack
    private final Stack<SimpleVertex> stack;

    public DepthFirstSearch(SimpleVertex root) {
        this.stack = new Stack<>();
        this.stack.push(root.visit());
    }

    public void traversal(){
        System.out.println("Root is already visited [" + stack.peek() + "]");
        while (!stack.isEmpty()){
            SimpleVertex actual = this.stack.pop();
            for (SimpleVertex ver: actual.unvisitedAdjacent()){
                ver.visit();
                this.stack.push(ver);
                System.out.println("Visited [" + ver.name() + "]");
            }
        }
    }
}
