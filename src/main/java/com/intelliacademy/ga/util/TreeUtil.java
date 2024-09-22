package com.intelliacademy.ga.util;

public class TreeUtil {

    public static Tree<Integer> createTree() {
        Tree<Integer> tree = new InBalancedTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(13);
        tree.insert(17);
        tree.insert(24);
        return tree;
    }
}
