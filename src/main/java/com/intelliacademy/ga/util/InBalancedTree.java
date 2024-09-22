package com.intelliacademy.ga.util;

public class InBalancedTree<D extends Comparable<D>> implements Tree<D> {
    private Node<D> root = Node.NilNode.of();

    public void insert(D data) {
        if (root.isNil()) {
            root = new Node<>(data);
        } else {
            root.insert(data);
        }
    }

    public void traverseInOrder() {
        root.traverseInOrder();
    }
}
