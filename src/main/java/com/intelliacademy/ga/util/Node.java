package com.intelliacademy.ga.util;

interface AbstractNode{
    Boolean isNil();
}

public class Node <D extends Comparable<D>> implements AbstractNode , Comparable<Node<D>>{
    private final D data;
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
        return false;
    }

    @Override
    public int compareTo(Node<D> o) {
        if (o == null) return 1;
        return this.data.compareTo(o.data);
    }


    public static class NilNode<D extends Comparable<D>> extends Node<D> {
        public NilNode() {
            super(null);
        }

        public static <D extends Comparable<D>> NilNode<D> of() {
            return new NilNode<>();
        }

        @Override
        public Boolean isLeaf() {
            return false;
        }

        @Override
        public Boolean hasLeft() {
            return false;
        }

        @Override
        public Boolean hasRight() {
            return false;
        }

        @Override
        public Boolean isNil() {
            return true;
        }

        @Override
        public Node<D> getLeft() {
            throw new UnsupportedOperationException("Cannot get left on NilNode");
        }

        @Override
        public Node<D> getRight() {
            throw new UnsupportedOperationException("Cannot get right on NilNode");
        }

        @Override
        public void setLeft(Node<D> left) {
            throw new UnsupportedOperationException("Cannot set left on NilNode");
        }

        @Override
        public void setRight(Node<D> right) {
            throw new UnsupportedOperationException("Cannot set right on NilNode");
        }

        @Override
        public int compareTo(Node<D> o) {
            if (o == null) return 1;
            if (o.isNil()) return 0;
            return -1;
        }
    }
}
