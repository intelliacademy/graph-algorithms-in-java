package com.intelliacademy.ga.util;

interface AbstractNode{
    Boolean isNil();
}

public class Node <D extends Comparable<D>> implements AbstractNode , Comparable<Node<D>>{
    private D data;
    private Node<D> left;
    private Node<D> right;

    public Node(D data) {
        this.data = data;
        this.left = NilNode.of();
        this.right = NilNode.of();
    }

    public D getData() {
        return data;
    }


    public void insert(D data) {
        var node = new Node<>(data);
        if (this.isGreaterThan(node)) {
            if (this.hasLeft()) {
                left.insert(data);
            } else {
                left = node;
            }
        } else {
            if (this.hasRight()) {
                right.insert(data);
            } else {
                right = node;
            }
        }
    }

    public void traverseInOrder() {
        if (this.isNil()) {
            return;
        }
        left.traverseInOrder();
        System.out.println(data);
        right.traverseInOrder();
    }

    public Boolean isGreaterThan(Node<D> node) {
        return this.compareTo(node) > 0;
    }

    public Boolean isLessThan(Node<D> node) {
        return this.compareTo(node) < 0;
    }

    public Boolean isEqualTo(Node<D> node) {
        return this.compareTo(node) == 0;
    }

    public Boolean isGreaterThanOrEqualTo(Node<D> node) {
        return this.compareTo(node) >= 0;
    }

    public Boolean isLessThanOrEqualTo(Node<D> node) {
        return this.compareTo(node) <= 0;
    }

    public Boolean isNotEqualTo(Node<D> node) {
        return this.compareTo(node) != 0;
    }

    public Boolean isLeaf() {
        return left.isNil() && right.isNil();
    }

    public Node<D> getLeft() {
        return left;
    }

    public Node<D> getRight() {
        return right;
    }

    public void setLeft(Node<D> left) {
        this.left = left;
    }

    public void setRight(Node<D> right) {
        this.right = right;
    }

    public Boolean hasLeft() {
        return !left.isNil();
    }

    public Boolean hasRight() {
        return !right.isNil();
    }

    public Boolean isNotLeaf() {
        return !isLeaf();
    }

    @Override
    public Boolean isNil() {
        return this.data == null;
    }

    @Override
    public int compareTo(Node<D> o) {
        if (o == null || o.isNil()) return 1;
        if (this.isNil()) return -1;
        return this.data.compareTo(o.data);
    }


    public static class NilNode<D extends Comparable<D>> extends Node<D> {
        public final static Node<?> NIL = new NilNode<>();

        public NilNode() {
            super(null);
        }

        public static <D extends Comparable<D>> Node<D> of() {
            return (Node<D>) NIL;
        }
    }
}
